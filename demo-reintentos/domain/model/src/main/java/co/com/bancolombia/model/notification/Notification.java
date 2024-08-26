package co.com.bancolombia.model.notification;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Notification {
    private String id;
    private Integer retries;
}
