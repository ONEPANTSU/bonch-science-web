package BSWeb.controllers.admin;

import BSWeb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin/panel")
public class PanelController {
    @Autowired
    User user;

    @GetMapping("")
    public String panel(Model model)
    {
        if (user.getAccess_level() == null){
            return "redirect:/admin/login";
        }

        switch ((Integer) user.getAccess_level()) {
            case 0: // writer
            case 1: // leader
                return "admin/panelPage";
            default:
                return "redirect:/admin/login";
        }
    }

    @GetMapping("/events")
    public String events(Model model)
    {
        if (user.getAccess_level() == null){
            return "redirect:/admin/login";
        }
        else if ((Integer) user.getAccess_level() == 0){
            return "admin/panel/eventsPage";
        }
        else {
            return "redirect:/news";
        }
    }

    @GetMapping("/news")
    public String news(Model model)
    {
        if (user.getAccess_level() == null){
            return "redirect:/admin/login";
        }
        else if ((Integer) user.getAccess_level() == 0){
            return "admin/panel/newsPage";
        }
        else {
            return "redirect:/news";
        }
    }

    @GetMapping("/scientific-and-educational-centers")
    public String SECs(Model model)
    {
        if (user.getAccess_level() == null){
            return "redirect:/admin/login";
        }
        else if ((Integer) user.getAccess_level() == 0){
            return "admin/panel/secPage";
        }
        else {
            return "redirect:/news";
        }
    }
}