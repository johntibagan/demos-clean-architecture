package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.usecase.notification.NotificationUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.api.domain.Command;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandsHandlerTest {

    @Mock
    NotificationUseCase notificationUseCase;
    @InjectMocks
    CommandsHandler commandsHandler;

    @Test
    void handleCommandATest() {

        when(notificationUseCase.send(any())).thenReturn(Mono.error(new Throwable("Error")));

        StepVerifier.create(commandsHandler.handler(
                        new Command<>("COMMAND",
                                UUID.randomUUID().toString(),
                                Notification.builder().build())))
                .expectErrorMatches(e -> e.getMessage().equals("Error"))
                .verify();
    }
}
