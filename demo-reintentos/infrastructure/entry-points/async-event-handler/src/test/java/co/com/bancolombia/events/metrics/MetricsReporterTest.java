package co.com.bancolombia.events.metrics;

import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import io.micrometer.core.instrument.logging.LoggingRegistryConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.commons.communications.Message;
import reactor.test.StepVerifier;

public class MetricsReporterTest {

    private MetricsReporter metricsReporter;
    private Exception error;
    private Message message;

    @BeforeEach
    void setUp() {
        LoggingMeterRegistry loggingMeterRegistry = LoggingMeterRegistry
                .builder(LoggingRegistryConfig.DEFAULT)
                .build();

        metricsReporter = new MetricsReporter(loggingMeterRegistry);
        metricsReporter.reportMetric("type", "path", 10L, true);

        error = new IllegalArgumentException("Error");

        message = new Message() {
            @Override
            public byte[] getBody() {
                return new byte[0];
            }

            @Override
            public Properties getProperties() {
                return null;
            }
        };
    }

    @Test
    void reportErrorCommandTest() {
        Command<String> command = new Command<>("name", "commandID", "data");

        StepVerifier
                .create(metricsReporter.reportError(error, message, command, true))
                .verifyComplete();
    }

    @Test
    void reportErrorDomainEventTest() {
        DomainEvent<String> domainEvent = new DomainEvent<>("name", "eventID", "data");

        StepVerifier
                .create(metricsReporter.reportError(error, message, domainEvent, true))
                .verifyComplete();
    }

    @Test
    void reportErrorAsyncQueryTest() {
        AsyncQuery<String> asyncQuery = new AsyncQuery<>("resource", "data");

        StepVerifier
                .create(metricsReporter.reportError(error, message, asyncQuery, true))
                .verifyComplete();
    }
}