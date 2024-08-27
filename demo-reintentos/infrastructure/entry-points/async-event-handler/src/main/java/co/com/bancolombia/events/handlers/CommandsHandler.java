package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.usecase.notification.NotificationUseCase;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableCommandListeners
public class CommandsHandler {

    private final NotificationUseCase notificationUseCase;

    public Mono<Void> handler(Command<Notification> event) {
        System.out.println("command received: " + event.getName() + " ->" + event.getData());
        return notificationUseCase.send(event.getData());
    }
}
