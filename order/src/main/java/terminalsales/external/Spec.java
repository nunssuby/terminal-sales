package terminalsales.external;

import java.util.Date;
import lombok.Data;

@Data
public class Spec {

    private Long id;
    private String phoneName;
    private String phoneColor;
    private String phoneType;
    private Object image;
    private Object detailSpec;
    private Long price;
}
