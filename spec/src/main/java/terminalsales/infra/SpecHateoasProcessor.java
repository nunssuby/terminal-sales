package terminalsales.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import terminalsales.domain.*;

@Component
public class SpecHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Spec>> {

    @Override
    public EntityModel<Spec> process(EntityModel<Spec> model) {
        return model;
    }
}
