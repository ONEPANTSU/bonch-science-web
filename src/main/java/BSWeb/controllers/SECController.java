package BSWeb.controllers;

import BSWeb.models.*;
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
import java.util.Collections;
import java.util.Optional;

@Controller
@RequestMapping("/scientific-and-educational-centers")
public class SECController {
    @Autowired
    User user;
    @Autowired
    private SECRepository secRepository;
    @Autowired
    private AchievementsRepository achRepository;
    //@Autowired
    //private SECAchieveRepository secAchieveRepository;

    @GetMapping("")
    public String sec(Model model) {
        Iterable<SEC> sec = secRepository.findAll();
        model.addAttribute("sec", sec);
        model.addAttribute("title", "Научно-образовательные центры");

        if (user.getAccess_level() == null){
            return "secPage";
        }
        switch ((Integer) user.getAccess_level()) {
            case 0: // writer
            case 1: // leader
                return "admin/secPage";
            default:
                return "secPage";
        }
    }

    /*private void prepareModelByID(Model model, Long id){
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
    }*/

    private void prepareModelByID(Model model, Long secid){
        model.addAttribute("secid", secid);

        Optional<SEC> sec = secRepository.findById(secid);  // fullname, decription
        if (sec.isPresent()) {
            model.addAttribute("sec", sec.get());
            model.addAttribute("title", sec.get().getTitle());
        }

        var outAch = new ArrayList<Achievements>();
        Iterable<Achievements> allAch = achRepository.findAll();

        for (var item : allAch){
            if (item.getSecid() == secid) {
                outAch.add(item);
            }

        }

        //model.addAttribute("ach", outAch);
    }

    @GetMapping("/ТИОС")
    public String secAbout1(Model model) {
        Long secid = 1L;
        prepareModelByID(model, secid);

        if (user.getAccess_level() == null){
            return "secAboutPage";
        }
        switch ((Integer) user.getAccess_level()) {
            case 0: // writer
            case 1: // leader
                return "admin/secAboutPage";
            default:
                return "secAboutPage";
        }
    }

    @GetMapping("/БИС")
    public String secAbout2(Model model) {
        Long secid = 2L;
        prepareModelByID(model, secid);

        if (user.getAccess_level() == null){
            return "secAboutPage";
        }
        switch ((Integer) user.getAccess_level()) {
            case 0: // writer
            case 1: // leader
                return "admin/secAboutPage";
            default:
                return "secAboutPage";
        }
    }

    @GetMapping("/edit")
    public String editGetSEC(@RequestParam("id") Long id, Model model){
        if (user.getAccess_level() == null){  // проверка роли
            return "redirect:/scientific-and-educational-centers";
        }

        Iterable<SEC> secs = secRepository.findAllById(Collections.singleton(id));
        model.addAttribute("secs", secs);
        model.addAttribute("title", "Редактирование НОЦ");

        return "admin/secEditPage";

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

    @PostMapping("/achievements")
    public String addAchievement(@RequestParam("secid") Long secid,
                          @RequestParam("title") String title,
                          Model model){

        if (user.getAccess_level() != null){  // проверка роли
            Achievements achievement = new Achievements(secid, title);
            achRepository.save(achievement);
        }

        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/achievements/edit")
    public String editAchievement(@RequestParam("id") Long id,
                                  @RequestParam("secid") Long secid,
                                  @RequestParam("title") String title,
                                  Model model){

        if (user.getAccess_level() != null){  // проверка роли
            if(achRepository.existsById(id)) {
                Achievements achievement = new Achievements(id, secid, title);
                achRepository.save(achievement);
            }
        }

        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/achievements/delete")
    public String deleteAchievement(@RequestParam("id") Long id, Model model){

        if (user.getAccess_level() != null){  // проверка роли
            if(achRepository.existsById(id)) {
                achRepository.deleteById(id);
            }
        }

        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/edit")
    public String editSEC(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("full_name") String full_name,
                           @RequestParam("description") String description,
                           Model model){

        if (user.getAccess_level() != null){  // проверка роли
            if(secRepository.existsById(id)) {
                SEC sec = new SEC(id, title, full_name, description);
                secRepository.save(sec);
            }
        }

        return "redirect:/scientific-and-educational-centers";
    }

    @PostMapping("/delete")
    public String deleteSEC(@RequestParam("id") Long id,
                             Model model){

        if (user.getAccess_level() != null){  // проверка роли
            if(secRepository.existsById(id)) {
                secRepository.deleteById(id);
            }
        }

        return "redirect:/scientific-and-educational-centers";
    }
}
