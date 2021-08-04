package study.springbootdbcpconnectionpool;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
@RequiredArgsConstructor
public class AppInit implements CommandLineRunner {

    private final DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("dataSource = " + dataSource);
        System.out.println("dataSource.type = " + dataSource.getClass().getName());
        for (int i = 0; i < 100; i++) {
            Connection conn = dataSource.getConnection();
            System.out.println("conn = " + i + ". " + conn);
        }
    }
}
