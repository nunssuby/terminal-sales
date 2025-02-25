package terminalsales.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import terminalsales.config.kafka.KafkaProcessor;
import terminalsales.domain.*;

@Service
public class SalesDashBoardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SalesDashBoardRepository salesDashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDataCollected_then_CREATE_1(
        @Payload DataCollected dataCollected
    ) {
        try {
            if (!dataCollected.validate()) return;

            // view 객체 생성
            SalesDashBoard salesDashBoard = new SalesDashBoard();
            // view 객체에 이벤트의 Value 를 set 함
            salesDashBoard.setPhoneName(dataCollected.getPhoneName());
            salesDashBoard.setPhoneColor(dataCollected.getPhoneColor());
            salesDashBoard.setGender(dataCollected.getGender());
            salesDashBoard.setRegion(dataCollected.getRegion());
            salesDashBoard.setPrice(dataCollected.getPrice());
            // view 레파지 토리에 save
            salesDashBoardRepository.save(salesDashBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
