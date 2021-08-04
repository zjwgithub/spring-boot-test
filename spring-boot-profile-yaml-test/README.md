### src/main/resources 폴더 구성
    src/main
        /resources
            application.yaml
        /resources-dev
            application.yaml
        /resources-prod
            application.yaml

### build.gradle 설정 추가
    ext.profile = (!project.hasProperty('profile') || !profile) ? 'local' : profile
    
    sourceSets {
        main {
            resources {
                srcDirs "src/main/resources", "src/main/resources-${profile}"
            }
        }
    }

### profile 별 gradle build 방법
    ./gradlew clean build -Pprofile=dev
