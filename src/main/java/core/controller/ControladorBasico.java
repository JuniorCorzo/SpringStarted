package core.controller;

import core.components.PostComponents;
import core.configuration.Pages;
import core.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ControladorBasico {

    @Autowired
    private PostComponents _postComponents;

    @GetMapping(path = {"/posts", "/"})
    public String saludar(Model model) {
        model.addAttribute("posts", this._postComponents.getPost());
        return Pages.HOME;
    }

    //Forma de enviar informacion por el link dondole un nombre y separandolas por ?
    @GetMapping(path = {"post"})
    public ModelAndView getIndividualPost(@RequestParam(defaultValue = "1" ,name = "id", required = false) int id) {
        ModelAndView modelAndView = new ModelAndView(Pages.POST);
        List<Post> postFiltre = this._postComponents.getPost().stream()
                .filter(post -> post.getId() == id)
                .toList();
        modelAndView.addObject("post", postFiltre.get(0));
        return modelAndView;
    }


    //Forma de enviar informacion mediante la ruta separada por /
    @GetMapping("/post/p/{post}")
    public ModelAndView getIndividualPostWithPath(@PathVariable(name = "post") int id){
        ModelAndView modelAndView = new ModelAndView(Pages.POST);
        List<Post> postFiltre = this._postComponents.getPost().stream()
                .filter(post -> post.getId() == id)
                .toList();
        modelAndView.addObject("post", postFiltre.get(0));
        return modelAndView;
    }

    @GetMapping(path = "/postNew")
    public ModelAndView getForm(){
        return new ModelAndView("form").addObject("post", new Post());
    }

    @PostMapping("/addNewPost")
    public String addPost(Post post, Model model){
        List<Post> posts = this._postComponents.getPost();
        posts.add(post);
        model.addAttribute("posts", posts);
        return Pages.HOME;
    }
}
