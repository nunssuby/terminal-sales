package terminalsales.domain;

import terminalsales.domain.OrderPlaced;
import terminalsales.external.Spec;
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

        ObjectMapper mapper = new ObjectMapper();
        Map<Long, Object> specMap = mapper.convertValue(getSpecId(), Map.class);

        Spec spec = OrderApplication.applicationContext
            .getBean(terminalsales.external.SpecService.class)
            .getTerminal((Long)specMap.get("id"));

        this.setPrice(spec.getPrice());


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }

    public static void updatePaymentInfo(RequstPaymentCompleted requstPaymentCompleted){
        
        repository().findById(requstPaymentCompleted.getItemId()).ifPresent(operation->{
            
            operation.setPaymentId(requstPaymentCompleted.getId());
            operation.setPaymentStatus(requstPaymentCompleted.getStatus());
            repository().save(operation);
         });
    }

}
//>>> DDD / Aggregate Root
