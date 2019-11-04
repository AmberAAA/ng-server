package top.anborong.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    @GetMapping("/version")
    public String version1 () {
        return "v-0.0.4 ---- api/version";
    }
}
