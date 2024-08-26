package co.com.bancolombia.events;

import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.model.notification.gateways.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Level;

@Log
@AllArgsConstructor
@EnableDirectAsyncGateway
public class ReactiveDirectAsyncGateway implements NotificationRepository {

    public static final String TARGET_NAME = "DemoReintentos";// refers to remote spring.application.name property
    private final DirectAsyncGateway gateway;

    @Override
    public Mono<Void> save(Notification notification) {
        log.log(Level.INFO, "Sending command: {0}: {1}", new String[]{NOTIFY_PAYMENT, notification.toString()});
        var command = new Command<>(NOTIFY_PAYMENT, UUID.randomUUID().toString(), notification);
        return gateway.sendCommand(command, TARGET_NAME);
    }

    @Override
    public Mono<Void> send(Notification notification) {
        return Mono.empty();
    }
}
