package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.notification.Notification;
import co.com.bancolombia.usecase.notification.NotificationUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.reactivecommons.api.domain.DomainEvent;
import reactor.test.StepVerifier;

import java.util.UUID;

public class EventsHandlerTest {

    @Mock
    NotificationUseCase notificationUseCase;

    EventsHandler eventsHandler;

    @BeforeEach
    void setUp() {
        eventsHandler = new EventsHandler(notificationUseCase);
    }

    @Test
    void handlerTest() {
//        StepVerifier.create(eventsHandler.handleEventA(
//                new DomainEvent<>("EVENT",
//                        UUID.randomUUID().toString(),
//                        Notification.builder().build()))).expectComplete();

    }

}
