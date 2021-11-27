package BSWeb.controllers;

import BSWeb.models.Post;
import BSWeb.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/news")
    public String news(Model model) {

        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Новости от Bonch-Science!");

        return "newsPage";
    }

}
