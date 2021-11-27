package BSWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер главной страницы
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "Bonch-Science");
        model.addAttribute("description", "Комитет по научной работе СПбГУТ");
        return "mainPage";
    }


    @GetMapping("/about")
    public String about(Model model) {

        return "aboutPage";
    }

}