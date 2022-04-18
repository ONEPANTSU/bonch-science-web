package BSWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Контроллер главной страницы
 */

@Controller
public class MainController {

    @GetMapping("/")
    public RedirectView redirectToHome(RedirectAttributes attributes) {
        attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectAttributes");
        attributes.addAttribute("attribute", "redirectWithRedirectAttributes");
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public String greeting(Model model) {
        model.addAttribute("title", "Bonch-Science");
        model.addAttribute("description", "Комитет по научной работе СПбГУТ");
        return "mainPage";
    }


    @GetMapping("/about")
    public String about(Model model) {

        return "aboutPage";
    }


    @GetMapping("/hackathon")
    public String hackathon(Model model) {
        return "hackathon/hackathonPage";
    }


}