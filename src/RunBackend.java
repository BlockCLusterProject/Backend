import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({
    "Controllers",
    "ApiServices",
    "Models",
    "Repository"
})
public class RunBackend {
    public static void main(String[] args) {
        SpringApplication.run(RunBackend.class, args);
    }
}