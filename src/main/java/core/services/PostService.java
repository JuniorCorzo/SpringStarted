package core.services;

import core.model.Post;

import java.util.List;

public interface PostService {
    List<Post> validation(List<Post> posts);
}
