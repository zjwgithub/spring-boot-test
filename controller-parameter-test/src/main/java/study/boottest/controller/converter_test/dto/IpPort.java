package study.boottest.controller.converter_test.dto;

import lombok.Data;

@Data
public class IpPort {
    
    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
