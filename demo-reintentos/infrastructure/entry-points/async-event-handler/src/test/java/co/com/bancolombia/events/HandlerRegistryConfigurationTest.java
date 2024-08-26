package co.com.bancolombia.events;

import co.com.bancolombia.events.handlers.CommandsHandler;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.events.handlers.QueriesHandler;
import co.com.bancolombia.usecase.notification.NotificationUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.reactivecommons.async.api.HandlerRegistry;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HandlerRegistryConfigurationTest {

    @Mock
    NotificationUseCase notificationUseCase;

    EventsHandler eventsHandler;
    CommandsHandler commandsHandler;
    QueriesHandler queriesHandler;

    @BeforeEach
    void setUp() {
        eventsHandler = new EventsHandler(notificationUseCase);
        commandsHandler = new CommandsHandler();
        queriesHandler = new QueriesHandler();

    }

    @Test
    void testHandlerRegistry() {
        HandlerRegistryConfiguration handlerRegistryConfiguration = new HandlerRegistryConfiguration();
        HandlerRegistry handlerRegistry = handlerRegistryConfiguration.handlerRegistry(commandsHandler, eventsHandler, queriesHandler);

        assertNotNull(handlerRegistry);

    }
}
