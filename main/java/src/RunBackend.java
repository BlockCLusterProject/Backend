import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@ComponentScan(basePackages = {
    "Controllers",
    "ApiServices",
    "Models",
    "Repository",
    "config"
})
@EntityScan(basePackages = {
		"Models"
})

public class RunBackend {
    public static void main(String[] args) {
    	Dotenv dotenv = Dotenv.configure()
    			.ignoreIfMissing()
    			.load();
    	if(dotenv != null) {
    		dotenv.entries().forEach(entry -> {
    			if(System.getProperty(entry.getKey()) == null && 
    					System.getenv(entry.getKey()) == null) {
    				System.setProperty(entry.getKey(), entry.getValue());
    			}
    		});
    	}

		System.setProperty("db_url", dotenv.get("DB_URL"));
		System.setProperty("db_user", dotenv.get("USER_DB"));
		System.setProperty("db_password", dotenv.get("PASSWORD_DB"));
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
        SpringApplication.run(RunBackend.class, args);
    }
}


