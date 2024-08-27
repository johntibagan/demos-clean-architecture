package co.com.bancolombia.events.handlers;

import co.com.bancolombia.model.notification.Notification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivecommons.api.domain.DomainEvent;
import reactor.test.StepVerifier;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class EventsHandlerTest {

    @InjectMocks
    EventsHandler eventsHandler;

    @Test
    void handlerTest() {
        StepVerifier.create(eventsHandler.retry(
                        new DomainEvent<>("EVENT",
                                UUID.randomUUID().toString(),
                                Notification.builder().build())))
                .expectComplete();

    }
}
