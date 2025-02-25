package terminalsales.domain;

import java.util.*;
import lombok.*;
import terminalsales.domain.*;
import terminalsales.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String address;
    private Boolean breakInsurance;
    private Boolean lostInsurance;
    private Object specId;
    private Object userId;
    private Long price;
    private Long paymentId;
    private String paymentStatus;
}
