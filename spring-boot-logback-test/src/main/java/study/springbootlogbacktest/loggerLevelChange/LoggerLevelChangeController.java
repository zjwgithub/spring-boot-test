package study.springbootlogbacktest.loggerLevelChange;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggerLevelChangeController {

    @GetMapping("/logger/level/{level}")
    public String setLevel(@PathVariable Level level) {
        String loggerName = "study.springbootlogbacktest";
        Logger logger = (Logger) LoggerFactory.getLogger(loggerName);
//        logger.setLevel(Level.DEBUG);
        logger.setLevel(level);

        System.out.println();
        log.trace("logger level changed");
        log.debug("logger level changed");
        log.info("logger level changed");
        log.warn("logger level changed");
        log.error("logger level changed");

        Level level2 = logger.getLevel();
        return level2.levelInt + " " + level2.levelStr;
    }
}
