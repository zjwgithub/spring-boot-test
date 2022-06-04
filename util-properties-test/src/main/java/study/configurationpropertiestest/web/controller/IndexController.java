package study.configurationpropertiestest.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.configurationpropertiestest.web.config.CommonProps;
import study.configurationpropertiestest.web.config.DbProps;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final CommonProps commonProps;
    private final DbProps dbProps;

    @Value("#{common['server.host']}")
    private String serverHost;

    @Value("#{db['datasource.driverClassName']}")
    private String driverClassName;

    @GetMapping("/")
    public String index() {
        System.out.println("commonProps = " + commonProps);
        System.out.println("dbProps = " + dbProps);
        System.out.println("serverHost = " + serverHost);
        System.out.println("driverClassName = " + driverClassName);
        return "ok";
    }
}
