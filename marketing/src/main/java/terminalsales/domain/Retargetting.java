package terminalsales.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import terminalsales.MarketingApplication;
import terminalsales.domain.DiscountPolicyActivated;

@Entity
@Table(name = "Retargetting_table")
@Data
//<<< DDD / Aggregate Root
public class Retargetting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String productId;

    private Integer returnCount;

    public static RetargettingRepository repository() {
        RetargettingRepository retargettingRepository = MarketingApplication.applicationContext.getBean(
            RetargettingRepository.class
        );
        return retargettingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void increaseTargettingValue(SpecCompared specCompared) {
        //implement business logic here:

        /** Example 1:  new item 
        Retargetting retargetting = new Retargetting();
        repository().save(retargetting);

        DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(retargetting);
        discountPolicyActivated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if specCompared.specIduserId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> specComparationMap = mapper.convertValue(specCompared.getSpecId(), Map.class);
        // Map<Long, Object> specComparationMap = mapper.convertValue(specCompared.getUserId(), Map.class);

        repository().findById(specCompared.get???()).ifPresent(retargetting->{
            
            retargetting // do something
            repository().save(retargetting);

            DiscountPolicyActivated discountPolicyActivated = new DiscountPolicyActivated(retargetting);
            discountPolicyActivated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
