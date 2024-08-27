package co.com.bancolombia.events;

import co.com.bancolombia.events.handlers.CommandsHandler;
import co.com.bancolombia.events.handlers.EventsHandler;
import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.model.notification.gateways.NotificationRepository;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, EventsHandler events) {
        return HandlerRegistry.register()
                .handleCommand(NotificationRepository.NOTIFY_PAYMENT, commands::handler, Notification.class)
                .listenEvent(NotificationRepository.NOTIFY_PAYMENT + ".dlq", events::retry, Notification.class)
                ;
    }
}
