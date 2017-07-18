package za.co.deltaceti.samples.rest.services.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sample  webservices project")
                .description("Shows service with swagger docs, spring rest docs, spring data rest and jwt tokens for auth")
                .termsOfServiceUrl("http://www.deltaceti.co.za")
                .contact(new Contact("Evans Armitage", "www.deltaceti.co.za", "evans@deltaceti.co.za"))
                .license("Apache License Version 2.0")
                .version("1.0.0-SNAPSHOT")
                .build();
    }
}
