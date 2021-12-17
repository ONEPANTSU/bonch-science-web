package BSWeb.controllers;

import BSWeb.models.Post;
import BSWeb.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("")
    public String news(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("title", "Новости от Bonch-Science!");

        return "newsPage";
    }

    /**
     * Создать новую новость
     * @param title - Заголовок новости
     * @param text - Содержимое новости
     */
    @PostMapping("")
    public String addNews(@RequestParam("title") String title,
                          @RequestParam("text") String text,
                          Model model) {
        Post post = new Post(title, text);
        postRepository.save(post);
        return "redirect:news";
    }

    /**
     * Отредактировать новость
     * @param id - id новости (из БД)
     * @param title - Новый заголовок новости
     * @param text - Новое содержимое новости
     */
    @PostMapping("/edit")
    public String editNews(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("text") String text,
                           Model model){
        if(postRepository.existsById(id)) {
            Post post = new Post(id, title, text);
            postRepository.save(post);

        }
        return "redirect:/news";
    }

    /**
     * Удалить новость
     * @param id - id удаляемой новости (Из БД)
     */
    @PostMapping("/delete")
    public String deleteNews(@RequestParam("id") Long id,
                           Model model){
        if(postRepository.existsById(id)) {
            postRepository.deleteById(id);
        }
        return "redirect:/news";
    }
}