package co.com.bancolombia.usecase.notification;

import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.model.notification.gateways.NotificationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
public class NotificationUseCase {

    private final NotificationRepository repository;

    public Mono<Void> save() {
        return this.repository.save(Notification.builder().id(UUID.randomUUID().toString()).retries(0).build());
    }

    public Mono<Void> send(Notification notification) {
        notification.setRetries(notification.getRetries() + 1);
        return Mono.error(new Exception("Generando error ID: +" + notification.getId()));
    }
}
