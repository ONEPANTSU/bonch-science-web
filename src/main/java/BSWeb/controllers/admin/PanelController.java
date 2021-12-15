package BSWeb.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginContext;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;


@Controller
@RequestMapping("/admin/panel")
public class PanelController {
    @Autowired
    LoginController loginController;

    @GetMapping("")
    public String panel(Model model)
    {
        if (loginController.getAccess_level() != null && (Integer) loginController.getAccess_level() == 0){
            return "admin/panelPage";
        }
        else {
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/events")
    public String events(Model model)
    {
        if (loginController.getAccess_level() != null && (Integer) loginController.getAccess_level() == 0){
            return "admin/panel/eventsPage";
        }
        else {
            return "redirect:/admin/login";
        }
    }

    @GetMapping("/news")
    public String news(Model model)
    {
        if (loginController.getAccess_level() != null && (Integer) loginController.getAccess_level() == 0){
            return "admin/panel/newsPage";
        }
        else {
            return "redirect:/admin/login";
        }
    }
    @GetMapping("/scientific-and-educational-centers")
    public String SECs(Model model)
    {
        if (loginController.getAccess_level() != null && (Integer) loginController.getAccess_level() == 0){
            return "admin/panel/secPage";
        }
        else {
            return "redirect:/admin/login";
        }
    }
}