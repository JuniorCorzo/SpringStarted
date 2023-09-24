package core.services.Implemetation;

import core.model.Post;
import core.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> validation(List<Post> posts) {
        System.out.println("Primera Implementacion");
        for (Post post : posts) {
            if (post.getTitulo() == null) throw new NullPointerException("El titulo esta vacido");
        }
        return posts;
    }
}
