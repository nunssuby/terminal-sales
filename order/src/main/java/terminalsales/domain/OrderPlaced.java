package terminalsales.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import terminalsales.domain.*;
import terminalsales.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String address;
    private Boolean breakInsurance;
    private Boolean lostInsurance;
    private SpecId specId;
    private UserId userId;
    private Long price;
    private Long paymentId;
    private String paymentStatus;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
//>>> DDD / Domain Event
