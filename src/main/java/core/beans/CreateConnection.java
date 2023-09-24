package core.beans;

import core.model.Connection;
import core.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CreateConnection {
    @Bean(name = "beanUser")
    public User user(){
        return new User();
    }

    @Bean(name = "beanConnection")
    public Connection getConnection(){
        return new Connection("mysql", "localhost");
    }
}
