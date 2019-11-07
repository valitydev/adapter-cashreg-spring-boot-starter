package com.rbkmoney.adapter.cashreg.spring.boot.starter.processor;

import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.EntryStateModel;
import com.rbkmoney.adapter.cashreg.spring.boot.starter.model.ExitStateModel;

/**
 * Usage example:
 * <p>
 * Configuration:
 * <pre>
 * {@code
 *  @Configuration
 *  @RequiredArgsConstructor
 *  public class ProcessorConfiguration {
 *
 *     @Bean
 *     public Processor<ExitStateModel, EntryStateModel, CommonResponse> responseProcessorChain() {
 *         ErrorProcessor errorProcessor = new ErrorProcessor();
 *         return new SuccessProcessor(errorProcessor);
 *     }
 *
 *  }
 * }
 *
 * Dummy Success Processor:
 * <pre>
 * {@code
 *  @RequiredArgsConstructor
 *  public class SuccessProcessor implements Processor<ExitStateModel, EntryStateModel, CommonResponse> {
 *
 *     private final Processor<ExitStateModel, EntryStateModel, CommonResponse> nextProcessor;
 *
 *     @Override
 *     public ExitStateModel process(CommonResponse response, EntryStateModel entryStateModel) {
 *
 *        if(!response.hasError()) {
 *            return new ExitStateModel();
 *        }
 *
 *        return nextProcessor.process(response, entryStateModel);
 *     }
 *
 *  }
 * }
 * </pre>
 *
 * @param <T>
 * @param <E>
 * @param <R>
 */
public interface Processor<T extends ExitStateModel, E extends EntryStateModel, R> {
    T process(R response, E context);
}
