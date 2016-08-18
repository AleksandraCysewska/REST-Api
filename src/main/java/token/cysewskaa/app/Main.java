package token.cysewskaa.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by izydorczyka on 2016-08-01.
 */

//

@EntityScan(basePackages ="token.cysewskaa.entities")
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "token.cysewskaa")
@EnableJpaRepositories(basePackages = "token.cysewskaa.implementation")
public class Main extends SpringBootServletInitializer
    {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

        @Override
        protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
            return application.sources(Main.class);
        }

}
