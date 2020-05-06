package com.rbkmoney.adapter.cashreg.spring.boot.starter.converter;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.extractors.TypeExtractor;
import com.rbkmoney.damsel.cashreg.adapter.CashregAdapterSrv;
import com.rbkmoney.damsel.cashreg.adapter.CashregContext;
import com.rbkmoney.damsel.cashreg.adapter.CashregResult;
import com.rbkmoney.woody.api.flow.error.WErrorDefinition;
import com.rbkmoney.woody.api.flow.error.WErrorType;
import com.rbkmoney.woody.api.flow.error.WRuntimeException;
import com.rbkmoney.woody.api.trace.context.TraceContext;
import com.rbkmoney.woody.thrift.impl.http.error.THTransportErrorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;

/**
 * Usage example:
 * <p>
 * Configuration
 * <pre>
 * {@code
 *  @Configuration
 *  public class HandlerConfiguration {
 *
 *      @Bean
 *      @Autowired
 *      public CashregAdapterSrv.Iface serverHandlerLogDecorator(CashregAdapter cashregAdapter) {
 *          return new CashregAdapterServiceLogDecorator(cashregAdapter);
 *      }
 *
 *  }
 * }
 * </pre>
 * <p>
 * Servlet
 * <pre>
 * {@code
 *  @RequiredArgsConstructor
 *  @WebServlet("/adapter/cashreg/provider_name")
 *  public class AdapterServlet extends GenericServlet {
 *
 *     private final CashregAdapterSrv.Iface handler;
 *     private Servlet servlet;
 *
 *     @Override
 *     public void init(ServletConfig config) throws ServletException {
 *         super.init(config);
 *         servlet = new THServiceBuilder().build(CashregAdapterSrv.Iface.class, handler);
 *     }
 *
 *     @Override
 *     public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
 *         servlet.service(request, response);
 *     }
 *
 *  }
 * }
 * </pre>
 */
@Slf4j
@RequiredArgsConstructor
public class CashregAdapterServiceLogDecorator implements CashregAdapterSrv.Iface {

    private final CashregAdapterSrv.Iface handler;

    @Override
    public CashregResult register(CashregContext cashRegContext) throws TException {
        String cashregType = TypeExtractor.extractCashregType(cashRegContext);
        String cashregId = cashRegContext.getCashregId();
        log.info("Started: {} with cashreg Id {}", cashregType, cashregId);
        try {
            CashregResult regResult = handler.register(cashRegContext);
            log.info("Finished {} with cashreg Id {}", cashregType, cashregId);
            return regResult;
        } catch (Exception ex) {
            String message = "Failed handle " + cashregType + " with cashreg Id " + cashregId;
            logMessage(ex, message);
            throw ex;
        }
    }

    private static void logMessage(Exception ex, String message) {
        if (isUndefinedResultOrUnavailable(ex)) {
            log.warn(message, ex);
        } else {
            log.error(message, ex);
        }
    }

    private static boolean isUndefinedResultOrUnavailable(Exception exception) {
        WErrorDefinition definition;
        if (exception instanceof WRuntimeException) {
            definition = ((WRuntimeException) exception).getErrorDefinition();
        } else {
            THTransportErrorMapper errorMapper = new THTransportErrorMapper();
            definition = errorMapper.mapToDef(exception, TraceContext.getCurrentTraceData().getActiveSpan());
        }

        boolean undefined = definition != null && WErrorType.UNDEFINED_RESULT.getKey().equals(definition.getErrorType().getKey());
        boolean unavailable = definition != null && WErrorType.UNAVAILABLE_RESULT.getKey().equals(definition.getErrorType().getKey());
        return undefined || unavailable;
    }

}
