## logback-spring.xml
### ConsoleAppender
    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>
                %d{HH:mm:ss} %highlight(%5level) %magenta([%t]) %cyan(%-60(%logger{1}.%method\(%class{0}.java:%line\))) : %msg%n
            </Pattern>
        </layout>
    </appender>
    
### RollingFileAppender (daily one file)
    <appender name="RollingFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_DIR}/spring-boot-logger.log</file>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %5level ${HOSTNAME} [%t] %-60(%logger{10}.%method:%line) : %msg%n</Pattern>
        </encoder>

        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>
                ${LOG_DIR}/archived/spring-boot-logger.%d{yyyy-MM-dd}.log
            </fileNamePattern>
        </rollingPolicy>
    </appender>
    
### RollingFileAppender (daily multiple files by size)
    <appender name="RollingFile" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${LOG_DIR}/spring-boot-logger.log</file>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} %5level ${HOSTNAME} [%t] %-60(%logger{10}.%method:%line) : %msg%n</Pattern>
        </encoder>

        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <fileNamePattern>
                ${LOG_DIR}/archived/%d{yyyy-MM-dd}/spring-boot-logger.%d{yyyy-MM-dd}.%i.log
            </fileNamePattern>
            <timeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <maxFileSize>10KB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
    </appender>

### Logger
    <root level="info">
        <appender-ref ref="Console" />
        <appender-ref ref="RollingFile" />
    </root>

    <!-- LOG "study.springbootlogbacktest*" at TRACE level -->
    <logger name="study.springbootlogbacktest" level="trace" additivity="false">
        <appender-ref ref="Console" />
        <appender-ref ref="RollingFile" />
    </logger>