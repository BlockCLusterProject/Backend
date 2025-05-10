import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@ComponentScan(basePackages = {
    "Controllers",
    "ApiServices",
    "Models",
    "Repository"
})
@EntityScan(basePackages = {
		"Models"
    /*"Models.Admin",
    "Models.Client",
    "Models.Genre",
    "Models.Movie",
    "Models.Person"*/
})
// @EnableJpaRepositories("Repository")

public class RunBackend {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("db_url", dotenv.get("DB_URL"));
        System.setProperty("db_user", dotenv.get("USER_DB"));
        System.setProperty("db_password", dotenv.get("PASSWORD_DB"));
        System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
        SpringApplication.run(RunBackend.class, args);
    }
}