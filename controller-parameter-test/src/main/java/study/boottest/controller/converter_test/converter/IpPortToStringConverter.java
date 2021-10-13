package study.boottest.controller.converter_test.converter;

import org.springframework.core.convert.converter.Converter;
import study.boottest.controller.converter_test.dto.IpPort;

public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(IpPort source) {
        return source.getIp() + ":" + source.getPort();
    }
}
