package terminalsales.domain;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.ObjectMapper;

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

        ObjectMapper mapper = new ObjectMapper();
        Map<Long, Object> specMap = mapper.convertValue(orderPlaced.getSpecId(), Map.class);
        Map<String, Object> userMap = mapper.convertValue(orderPlaced.getUserId(), Map.class);

        InsuranceSubscription insuranceSubscription = new InsuranceSubscription();
        insuranceSubscription.setCustomerId(userMap.get("id").toString());
        insuranceSubscription.setTerminalProductId(specMap.get("id").toString());
        insuranceSubscription.setIsBreakCompensation(orderPlaced.getBreakInsurance());
        insuranceSubscription.setIsLostComponsation(orderPlaced.getLostInsurance());
        repository().save(insuranceSubscription);
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
