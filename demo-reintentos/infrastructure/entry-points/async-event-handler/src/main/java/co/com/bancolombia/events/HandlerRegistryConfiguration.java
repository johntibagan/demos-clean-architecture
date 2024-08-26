package co.com.bancolombia.events;

import co.com.bancolombia.events.handlers.CommandsHandler;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.events.handlers.QueriesHandler;
import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.model.notification.gateways.NotificationRepository;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    // see more at: https://reactivecommons.org/reactive-commons-java/#_handlerregistry_2
    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, EventsHandler events, QueriesHandler queries) {
        return HandlerRegistry.register()
                //.listenNotificationEvent("some.broadcast.event.name", events::handleEventA, Object.class/*change for proper model*/)
                .handleCommand(NotificationRepository.NOTIFY_PAYMENT, events::handler, Notification.class/*change for proper model*/)
                .listenEvent(NotificationRepository.NOTIFY_PAYMENT + ".dlq", events::retry, Notification.class)
                //.handleCommand("some.command.name", commands::handleCommandA, Object.class/*change for proper model*/)
                //.serveQuery("some.query.name", queries::handleQueryA, Object.class/*change for proper model*/)
                ;
    }
}
