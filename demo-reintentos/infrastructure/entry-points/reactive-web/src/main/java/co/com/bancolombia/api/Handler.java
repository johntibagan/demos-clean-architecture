package co.com.bancolombia.api;

import co.com.bancolombia.usecase.notification.NotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final NotificationUseCase notificationUseCase;

    public Mono<ServerResponse> saveNotification(ServerRequest serverRequest) {
        return this.notificationUseCase.save()
                .flatMap(c -> ServerResponse.ok().bodyValue(""));
    }
}
