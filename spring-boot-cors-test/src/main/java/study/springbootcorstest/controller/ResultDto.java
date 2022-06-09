package study.springbootcorstest.controller;

import lombok.Data;

@Data
public class ResultDto {

    private boolean success;
    private String message;

    public ResultDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
