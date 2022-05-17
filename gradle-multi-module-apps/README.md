### settings.gradle
    rootProject.name = 'gs-multi-module'
    
    include 'library'
    include 'application'

### root project
    root
    - library
    - application

### library project
    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter'
        testImplementation('org.springframework.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    }
    
    bootJar {
      enabled = false
    }
    
    jar {
      enabled = true
    }

### application project
    dependencies {
    	implementation 'org.springframework.boot:spring-boot-starter-actuator'
    	implementation 'org.springframework.boot:spring-boot-starter-web'
    
    	implementation project(":library")
    	# api project(":library")
    
    	testImplementation('org.springframework.boot:spring-boot-starter-test') {
    		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
    	}
    }
    
    bootJar {
    	enabled = true
    }

