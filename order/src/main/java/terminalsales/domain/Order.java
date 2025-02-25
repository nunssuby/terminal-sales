package terminalsales.domain;

import terminalsales.domain.OrderPlaced;
import terminalsales.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name="Order_table")
@Data

//<<< DDD / Aggregate Root
public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String address;
    
    
    
    
    private Boolean breakInsurance;
    
    
    
    
    private Boolean lostInsurance;
    
    
    
    @Embedded
    private SpecId specId;
    
    
    
    @Embedded
    private UserId userId;
    
    
    
    
    private Long price;
    
    
    
    
    private Long paymentId;
    
    
    
    
    private String paymentStatus;

    @PostPersist
    public void onPostPersist(){
    Spec spec = OrderApplication.applicationContext
        .getBean(terminalsales.external.SpecService.class)
        .getTerminal(get??);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
//>>> DDD / Aggregate Root
