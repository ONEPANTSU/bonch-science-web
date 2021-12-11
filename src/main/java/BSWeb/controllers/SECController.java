package BSWeb.controllers;

import BSWeb.models.SEC;
import BSWeb.models.Achievements;
import BSWeb.models.Sec_achieve;
import BSWeb.repo.AchievmentsRepository;
import BSWeb.repo.SECAchievmentsRepository;
import BSWeb.repo.SECRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class SECController {

    @Autowired
    private SECRepository secRepository;
    @Autowired
    private SECAchievmentsRepository secAchRepository;
    @Autowired
    private AchievmentsRepository achRepository;

    @GetMapping(value = "/scientific-and-educational-centers")
    public String sec(Model model) {
        Iterable<SEC> sec = secRepository.findAll();
        model.addAttribute("sec", sec);
        model.addAttribute("title", "Научно-образовательные центры");

        return "secPage";
    }

    @GetMapping(value = "/scientific-and-educational-centers/ТИОС")
    public String secAboutTIOS(Model model) {
        Long id = 1L;

        model = createSECAboutModel(id, model);

        return "secAboutPage";
    }

    @GetMapping(value = "/scientific-and-educational-centers/БИС")
    public String secAboutBIS(Model model) {
        Long id = 2L;

        model = createSECAboutModel(id, model);

        return "secAboutPage";
    }

    private Model createSECAboutModel(Long id, Model model){
        Iterable<SEC> sec = secRepository.findAllById(Collections.singleton(id));
        model.addAttribute("sec", sec);
        return model;
    }

}
