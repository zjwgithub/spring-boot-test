### application.yml
    logging:
      level:
        root: info
        study.springbootloggingtest: trace
      pattern:
        console: '%d{HH:mm:ss} %clr(%5level) %magenta([%t]) %cyan(%-60(%logger{1}\(%class{0}.java:%line\))) : %msg%n'
