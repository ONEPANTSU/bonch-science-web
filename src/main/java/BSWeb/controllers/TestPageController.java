package BSWeb.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;


@Controller
@RequestMapping("/admin")
public class TestPageController {
    @GetMapping("/t")
    public String about(Model model) {

        return "admin/testpage";
    }
}
