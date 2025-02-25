package terminalsales.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import terminalsales.InsuranceApplication;

@Entity
@Table(name = "InsuranceSubscription_table")
@Data
//<<< DDD / Aggregate Root
public class InsuranceSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String terminalProductId;

    private Boolean isBreakCompensation;

    private Boolean isLostComponsation;

    public static InsuranceSubscriptionRepository repository() {
        InsuranceSubscriptionRepository insuranceSubscriptionRepository = InsuranceApplication.applicationContext.getBean(
            InsuranceSubscriptionRepository.class
        );
        return insuranceSubscriptionRepository;
    }

    //<<< Clean Arch / Port Method
    public static void subscribeInsurance(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        InsuranceSubscription insuranceSubscription = new InsuranceSubscription();
        repository().save(insuranceSubscription);

        */

        /** Example 2:  finding and process
        
        // if orderPlaced.specIduserId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> orderMap = mapper.convertValue(orderPlaced.getSpecId(), Map.class);
        // Map<String, Object> orderMap = mapper.convertValue(orderPlaced.getUserId(), Map.class);

        repository().findById(orderPlaced.get???()).ifPresent(insuranceSubscription->{
            
            insuranceSubscription // do something
            repository().save(insuranceSubscription);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
