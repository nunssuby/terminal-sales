package terminalsales.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spec", url = "${api.url.spec}")
public interface SpecService {
    @GetMapping(path = "/specs/{id}")
    public Spec getTerminal(@PathVariable("id") Long id);
}
