package study.configurationpropertiestest.web.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PropertyConfigTest {

    @Autowired
    CommonProps commonProps;

    @Autowired
    DbProps dbProps;

    @Value("#{common['server.host']}")
    String serverHost;

    @Value("#{db['datasource.driverClassName']}")
    String driverClassName;

    @Test
    void propTest() {
        System.out.println("commonProps = " + commonProps);
        System.out.println("dbProps = " + dbProps);
        System.out.println("serverHost = " + serverHost);
        System.out.println("driverClassName = " + driverClassName);

        assertThat(serverHost).isEqualTo("my-server-host");
        assertThat(driverClassName).isEqualTo("org.h2.Driver");
    }
}
