package terminalsales.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import terminalsales.domain.*;

@Component
public class RetargettingHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Retargetting>> {

    @Override
    public EntityModel<Retargetting> process(EntityModel<Retargetting> model) {
        return model;
    }
}
