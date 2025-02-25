package terminalsales.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import terminalsales.domain.*;

@Component
public class SpecComparationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SpecComparation>> {

    @Override
    public EntityModel<SpecComparation> process(
        EntityModel<SpecComparation> model
    ) {
        return model;
    }
}
