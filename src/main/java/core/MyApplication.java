package core;

import core.components.PostComponents;
import core.model.Connection;
import core.services.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@SpringBootApplication
public class MyApplication implements CommandLineRunner {
    @Autowired
    @Qualifier("beanConnection")
    private Connection connection;

    @Autowired
    @Qualifier("core.components.PostComponents")
    private PostComponents postCompenents;

    @Autowired
    @Qualifier("ServiceDecorado")
    public PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       try {
        postService.validation(this.postCompenents.getPost())
                .forEach(post -> System.out.println(post.getTitulo()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
