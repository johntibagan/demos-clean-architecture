package co.com.bancolombia.model.notification.gateways;

import co.com.bancolombia.model.notification.Notification;
import reactor.core.publisher.Mono;

public interface NotificationRepository {

    public static final String NOTIFY_PAYMENT = "notify.payment";

    Mono<Void> save(Notification notification);

    Mono<Void> send(Notification notification);
}
