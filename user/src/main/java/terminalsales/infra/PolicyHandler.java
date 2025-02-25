package terminalsales.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import terminalsales.config.kafka.KafkaProcessor;
import terminalsales.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    UserRepository userRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DiscountPolicyActivated'"
    )
    public void wheneverDiscountPolicyActivated_AddCoupon(
        @Payload DiscountPolicyActivated discountPolicyActivated
    ) {
        DiscountPolicyActivated event = discountPolicyActivated;
        System.out.println(
            "\n\n##### listener AddCoupon : " + discountPolicyActivated + "\n\n"
        );

        // Sample Logic //
        User.addCoupon(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
