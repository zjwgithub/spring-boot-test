package study.boottest.controller.converter_test.converter;

import org.junit.jupiter.api.Test;
import study.boottest.controller.converter_test.dto.IpPort;

class StringToIpPortConverterTest {

    @Test
    void stringToIpPort() {
        String str = "127,0.0.1:8080";
        StringToIpPortConverter converter = new StringToIpPortConverter();
        IpPort ipPort = converter.convert(str);
        System.out.println("ipPort = " + ipPort);
    }

    @Test
    void ipPortToString() {
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        IpPortToStringConverter converter = new IpPortToStringConverter();
        String str = converter.convert(ipPort);
        System.out.println("str = " + str);
    }
}