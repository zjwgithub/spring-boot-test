package study.boottest.controller.formatter_test.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {

    MyNumberFormatter myNumberFormatter = new MyNumberFormatter();

    @Test

    void parse() throws ParseException {
        String text = "1,000";
        Number result = myNumberFormatter.parse(text, Locale.KOREA);
        System.out.println("result = " + result);
    }

    @Test
    void print() {
        String result = myNumberFormatter.print(1000, Locale.KOREA);
        System.out.println("result = " + result);
    }
}
