package study.configurationpropertiestest.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:properties/properties-config.xml")
public class PropertyConfig {

}
