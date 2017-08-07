package school.thoughtworks.system.app.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import school.thoughtworks.system.app.demo.gateway.filter.PostFilter;
import school.thoughtworks.system.app.demo.gateway.filter.PreFilter;

@EnableZuulProxy
@SpringBootApplication
public class  GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public PreFilter getPreFilter(){
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter(){
        return new PostFilter();
    }
}
