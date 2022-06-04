package study.configurationpropertiestest.web.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter @Setter
@ToString
@Component
public class DbProps {

    @Value("#{db['datasource.driverClassName']}")
    private String driverClassName;

    @Value("#{db['datasource.url']}")
    private String url;

    @Value("#{db['datasource.username']}")
    private String username;

    @Value("#{db['datasource.password']}")
    private String password;
}
