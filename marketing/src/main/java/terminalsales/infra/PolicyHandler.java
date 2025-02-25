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
    RetargettingRepository retargettingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='SpecCompared'"
    )
    public void wheneverSpecCompared_IncreaseTargettingValue(
        @Payload SpecCompared specCompared
    ) {
        SpecCompared event = specCompared;
        System.out.println(
            "\n\n##### listener IncreaseTargettingValue : " +
            specCompared +
            "\n\n"
        );

        // Sample Logic //
        Retargetting.increaseTargettingValue(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
