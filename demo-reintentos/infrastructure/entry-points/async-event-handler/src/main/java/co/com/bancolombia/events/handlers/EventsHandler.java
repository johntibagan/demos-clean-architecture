package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.notification.Notification;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {

    public Mono<Void> retry(DomainEvent<Notification> event) {
        System.out.println("retry received: " + event.getName() + " ->" + event.getData()); // TODO: Remove this line
        return Mono.empty();
    }
}
