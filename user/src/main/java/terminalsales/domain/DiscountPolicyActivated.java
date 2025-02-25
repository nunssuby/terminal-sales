package terminalsales.domain;

import java.util.*;
import lombok.*;
import terminalsales.domain.*;
import terminalsales.infra.AbstractEvent;

@Data
@ToString
public class DiscountPolicyActivated extends AbstractEvent {

    private Long id;
    private String customerId;
    private String productId;
}
