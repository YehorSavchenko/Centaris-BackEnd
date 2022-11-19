package backend.configuration;

import backend.database.DataBaseClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DataBaseClient dataBaseClient() {
        return new DataBaseClient();
    }
}
