import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({
    "controladores.Backend",
    "controladores.FrontEnd",
    "modelos",
    "persistencia",
    "ApiServices",
    "ApiServices.BackEnd",
    "ApiServices.FrontEnd"
})
public class RunBackend {
    public static void main(String[] args) {
        SpringApplication.run(RunBackend.class, args);
    }
}