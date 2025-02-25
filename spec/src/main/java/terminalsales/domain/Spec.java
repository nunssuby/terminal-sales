package terminalsales.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import terminalsales.SpecApplication;

@Entity
@Table(name = "Spec_table")
@Data
//<<< DDD / Aggregate Root
public class Spec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneName;

    private String phoneColor;

    private String phoneType;

    @Embedded
    private Photo image;

    @Embedded
    private DetailSpec detailSpec;

    private Long price;

    public static SpecRepository repository() {
        SpecRepository specRepository = SpecApplication.applicationContext.getBean(
            SpecRepository.class
        );
        return specRepository;
    }
}
//>>> DDD / Aggregate Root
