package terminalsales.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "SalesDashBoard_table")
@Data
public class SalesDashBoard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String phoneName;
    private String phoneColor;
    private String gender;
    private String region;
    private Integer price;
}
