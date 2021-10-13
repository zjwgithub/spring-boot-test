package study.boottest.controller.converter_test.converter;

import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.converter_test.dto.IpPort;

public class StringToIpPortConverter implements Converter<String, IpPort> {
    
    @Override
    public IpPort convert(String source) {
        String[] strings = source.split(":");
        String ip = strings[0];
        int port = Integer.parseInt(strings[1]);
        return new IpPort(ip, port);
    }
}
