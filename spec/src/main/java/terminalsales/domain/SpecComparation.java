package terminalsales.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import terminalsales.SpecApplication;
import terminalsales.domain.SpecCompared;

@Entity
@Table(name = "SpecComparation_table")
@Data
//<<< DDD / Aggregate Root
public class SpecComparation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private UserId userId;

    @ElementCollection
    private List<SpecId> specId;

    @PostPersist
    public void onPostPersist() {
        SpecCompared specCompared = new SpecCompared(this);
        specCompared.publishAfterCommit();
    }

    public static SpecComparationRepository repository() {
        SpecComparationRepository specComparationRepository = SpecApplication.applicationContext.getBean(
            SpecComparationRepository.class
        );
        return specComparationRepository;
    }
}
//>>> DDD / Aggregate Root
