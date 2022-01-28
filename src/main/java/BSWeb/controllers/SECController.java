package BSWeb.controllers;

import BSWeb.models.SEC;
import BSWeb.models.Achievements;
import BSWeb.models.SECAchieve;
import BSWeb.repo.AchievementsRepository;
import BSWeb.repo.SECAchieveRepository;
import BSWeb.repo.SECRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/scientific-and-educational-centers")
public class SECController {

    @Autowired
    private SECRepository secRepository;
    @Autowired
    private AchievementsRepository achRepository;
    @Autowired
    private SECAchieveRepository secAchieveRepository;

    @GetMapping("")
    public String sec(Model model) {
        Iterable<SEC> sec = secRepository.findAll();
        model.addAttribute("sec", sec);
        model.addAttribute("title", "Научно-образовательные центры");

        return "secPage";
    }

    private void prepareModelByID(Model model, Long id){
        Optional<SEC> sec = secRepository.findById(id);  // fullname, decription
        Iterable<SECAchieve> secAch = secAchieveRepository.findAll();

        // пока что так...
        var achIDs = new ArrayList<Long>();

        for (var item : secAch){
            if (item.getSec_id() == id) {
                achIDs.add(item.getAchieve_id());
            }
        }

        Iterable<Achievements> ach = achRepository.findAllById(achIDs);

        if (sec.isPresent()) {
            model.addAttribute("sec", sec.get());
            model.addAttribute("title", sec.get().getTitle());
        }
        model.addAttribute("ach", ach);
    }

    @GetMapping("/ТИОС")
    public String secAbout1(Model model) {
        Long id = 1L;
        prepareModelByID(model, id);
        return "secAboutPage";
    }

    @GetMapping("/БИС")
    public String secAbout2(Model model) {
        Long id = 2L;
        prepareModelByID(model, id);
        return "secAboutPage";
    }

    @PostMapping("")
    public String addSEC(@RequestParam("title") String title,
                          @RequestParam("full_name") String full_name,
                          @RequestParam("description") String description,
                          Model model) {
        SEC sec = new SEC(title, full_name, description);
        secRepository.save(sec);
        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/edit")
    public String editSEC(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("full_name") String full_name,
                           @RequestParam("description") String description,
                           Model model){
        if(secRepository.existsById(id)) {
            SEC sec = new SEC(id, title, full_name, description);
            secRepository.save(sec);

        }
        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/delete")
    public String deleteSEC(@RequestParam("id") Long id,
                             Model model){
        if(secRepository.existsById(id)) {
            secRepository.deleteById(id);
        }
        return "redirect:/scientific-and-educational-centers";
    }
}
