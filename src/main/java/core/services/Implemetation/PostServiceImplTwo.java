package core.services.Implemetation;

import core.model.Post;
import core.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ValidationId")
public class PostServiceImplTwo implements PostService {
    @Override
    public List<Post> validation(List<Post> posts) {
        System.out.println("Segunda implementacion");
        for (Post post : posts) {
            if (post.getId() == 0) throw new NullPointerException("Valor del id 0");
        }
        return posts;
    }
}
