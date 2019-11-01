package com.rbkmoney.adapter.cashreg.spring.boot.starter.converter;


import com.rbkmoney.adapter.cashreg.spring.boot.starter.utils.extractors.TypeExtractor;
import com.rbkmoney.damsel.cashreg.provider.CashRegContext;
import com.rbkmoney.damsel.cashreg.provider.CashRegProviderSrv;
import com.rbkmoney.damsel.cashreg.provider.CashRegResult;
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
 *      public CashRegProviderSrv.Iface serverHandlerLogDecorator(CashRegProvider cashRegProvider) {
 *          return new CashRegAdapterServiceLogDecorator(cashRegProvider);
 *      }
 *
 *  }
 * }
 * </pre>
 * <p>
 * Servlet
 * <pre>
 * {@code
 * @RequiredArgsConstructor
 * @WebServlet("/adapter/cashreg/provider_name")
 * public class AdapterServlet extends GenericServlet {
 *
 *     private final CashRegProviderSrv.Iface handler;
 *     private Servlet servlet;
 *
 *     @Override
 *     public void init(ServletConfig config) throws ServletException {
 *         super.init(config);
 *         servlet = new THServiceBuilder().build(CashRegProviderSrv.Iface.class, handler);
 *     }
 *
 *     @Override
 *     public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
 *         servlet.service(request, response);
 *     }
 *
 * }
 * }
 * </pre>
 */
@Slf4j
@RequiredArgsConstructor
public class CashRegAdapterServiceLogDecorator implements CashRegProviderSrv.Iface {

    private final CashRegProviderSrv.Iface handler;

    @Override
    public CashRegResult register(CashRegContext cashRegContext) throws TException {
        String cashRegType = TypeExtractor.extractCashRegType(cashRegContext);
        String cashRegId = cashRegContext.getCashregId();
        log.info("Started: {} with cashRegId {}", cashRegType, cashRegId);
        try {
            CashRegResult regResult = handler.register(cashRegContext);
            log.info("Finished {} with cashRegId {}", cashRegType, cashRegId);
            return regResult;
        } catch (Exception ex) {
            String message = "Failed handle " + cashRegType + " with cashRegId " + cashRegId;
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
