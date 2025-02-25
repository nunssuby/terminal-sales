package terminalsales.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import terminalsales.domain.*;

@Component
public class SalesDataHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SalesData>> {

    @Override
    public EntityModel<SalesData> process(EntityModel<SalesData> model) {
        return model;
    }
}
