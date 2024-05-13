package kr.co.hs.server.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Springdoc Swagger With OpenAPI 3
 *
 * @author hyoyoung-jung
 * @version 0.0.1
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openApi() {
        String company = "Hyosung";
        String title = company + " - Project";
        String version = "0.0.1-SNAPSHOT";
        Info info = new Info()
                .title(title)
                .version(version)
                .description(title + " | Version " + version)
                .contact(new Contact().name(company));
        return new OpenAPI().components(new Components()).info(info);
    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api")
                .packagesToScan("kr.co.hs.server.sample")
                .build();
    }
}

