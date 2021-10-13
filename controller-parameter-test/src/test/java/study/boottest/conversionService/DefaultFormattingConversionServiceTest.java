package study.boottest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import study.boottest.controller.converter_test.converter.IpPortToStringConverter;
import study.boottest.controller.converter_test.converter.StringToIpPortConverter;
import study.boottest.controller.converter_test.dto.IpPort;
import study.boottest.controller.formatter_test.formatter.MyNumberFormatter;

public class DefaultFormattingConversionServiceTest {

    DefaultFormattingConversionService defaultFormattingConversionService = new DefaultFormattingConversionService();

    @BeforeEach
    void setUp() {
        // formatter 등록
        defaultFormattingConversionService.addFormatter(new MyNumberFormatter());
        // converter 등록
        defaultFormattingConversionService.addConverter(new StringToIpPortConverter());
        defaultFormattingConversionService.addConverter(new IpPortToStringConverter());
    }

    @Test
    void formatter() {
        Number result = defaultFormattingConversionService.convert("1,000", Number.class);
        System.out.println("result = " + result);

        String result2 = defaultFormattingConversionService.convert(1000, String.class);
        System.out.println("result2 = " + result2);
    }

    @Test
    void converter() {
        String stringSource = "127.0.0.1:8080";
        IpPort ipPort = defaultFormattingConversionService.convert(stringSource, IpPort.class);
        System.out.println("ipPort = " + ipPort);

        IpPort ipPortSource = new IpPort("127.0.0.1", 8080);
        String string = defaultFormattingConversionService.convert(ipPortSource, String.class);
        System.out.println("string = " + string);
    }
}
