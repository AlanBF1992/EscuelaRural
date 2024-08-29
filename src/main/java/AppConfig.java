import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("cl.praxis")
public class AppConfig {

    Environment environment;

    public AppConfig(Environment environment) {
        this.environment = environment;
    }

}
