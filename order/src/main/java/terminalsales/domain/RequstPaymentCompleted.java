package terminalsales.domain;

import java.util.*;
import lombok.*;
import terminalsales.domain.*;
import terminalsales.infra.AbstractEvent;

@Data
@ToString
public class RequstPaymentCompleted extends AbstractEvent {

    private Long id;
    private Long itemId;
    private String paymentId;
    private String status;
    private String reason;
}