package study.boottest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;
import study.boottest.controller.converter_test.converter.IpPortToStringConverter;
import study.boottest.controller.converter_test.converter.StringToIpPortConverter;
import study.boottest.controller.converter_test.dto.IpPort;

public class DefaultConversionServiceTest {

    DefaultConversionService defaultConversionService = new DefaultConversionService();

    @BeforeEach
    void setUp() {
        // converter 등록
        defaultConversionService.addConverter(new StringToIpPortConverter());
        defaultConversionService.addConverter(new IpPortToStringConverter());
    }

    @Test
    void converter() {
        String stringSource = "127.0.0.1:8080";
        IpPort ipPort = defaultConversionService.convert(stringSource, IpPort.class);
        System.out.println("ipPort = " + ipPort);

        IpPort ipPortSource = new IpPort("127.0.0.1", 8080);
        String string = defaultConversionService.convert(ipPortSource, String.class);
        System.out.println("string = " + string);
    }
}
