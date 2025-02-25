package terminalsales.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import terminalsales.domain.*;
import terminalsales.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class DataCollected extends AbstractEvent {

    private Long id;
    private String phoneName;
    private String phoneColor;
    private String gender;
    private String region;
    private Integer price;

    public DataCollected(SalesData aggregate) {
        super(aggregate);
    }

    public DataCollected() {
        super();
    }
}
//>>> DDD / Domain Event
