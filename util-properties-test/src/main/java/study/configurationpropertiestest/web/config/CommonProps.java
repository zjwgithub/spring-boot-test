package study.configurationpropertiestest.web.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter @Setter
@ToString
@Component
public class CommonProps {

    @Value("#{common['server.host']}")
    private String serverHost;

    @Value("#{common['server.port']}")
    private int serverPort;

}
