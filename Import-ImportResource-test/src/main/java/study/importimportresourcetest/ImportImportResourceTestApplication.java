package study.importimportresourcetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import study.importimportresourcetest.config.MemberConfig;

@SpringBootApplication
@Import(MemberConfig.class)
@ImportResource("classpath:item-config.xml")
public class ImportImportResourceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportImportResourceTestApplication.class, args);
    }

}
