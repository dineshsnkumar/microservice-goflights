package io.projects.api_gateway.filters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/contact")
    public Mono<String> contactSupport(){
        return Mono.just("Something went wrong. Please contact the support team  ");
    }
}
