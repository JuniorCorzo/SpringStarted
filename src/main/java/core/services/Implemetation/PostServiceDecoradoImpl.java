package core.services.Implemetation;

import core.model.Post;
import core.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceDecorado")
public class PostServiceDecoradoImpl implements PostService {

    @Autowired
    private PostServiceImpl postServiceImpl;

    @Autowired
    private PostServiceImplTwo postServiceImplTwo;
    @Override
    public List<Post> validation(List<Post> posts) {
        posts = postServiceImpl.validation(posts);
        posts = postServiceImplTwo.validation(posts);

        for (Post post : posts) {
            if (post.getDescripcion() == null) throw new NullPointerException("La descripcion es nula");
            if (post.getFecha() == null) throw new NullPointerException("La fecha es nula");
        }
        System.out.println("Esta es la implementacion decorada");
        return posts;
    }
}
