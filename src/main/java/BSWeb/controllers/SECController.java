package BSWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SECController {


    @GetMapping("/scientific-and-educational-centers")
    public String sec(Model model) {

        return "secPage";
    }
}
