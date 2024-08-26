package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.usecase.notification.NotificationUseCase;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {
    private final NotificationUseCase notificationUseCase;


    public Mono<Void> handler(Command<Notification> event) {
        System.out.println("command received: " + event.getName() + " ->" + event.getData()); // TODO: Remove this line
//        return sampleUseCase.doSomething(event.getData());
        return notificationUseCase.send(event.getData());
    }

    public Mono<Void> retry(DomainEvent<Notification> event) {
        System.out.println("retry received: " + event.getName() + " ->" + event.getData()); // TODO: Remove this line
        return Mono.empty();
    }
}
