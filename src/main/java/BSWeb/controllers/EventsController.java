package BSWeb.controllers;

import BSWeb.models.Event;
import BSWeb.models.Post;
import BSWeb.models.User;
import BSWeb.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Collection;
import java.util.Collections;

@Controller
@RequestMapping("/events")
public class EventsController {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_username;
    @Value("${spring.datasource.password}")
    private String db_password;

    @Autowired
    User user;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("")
    public String event(Model model) {
        Iterable<Event> event = eventRepository.findAllByOrderByIdDesc();
        model.addAttribute("event", event);
        model.addAttribute("name","Мероприятия");


        if (user.getAccess_level() == null){
            return "eventsPage";
        }
        switch ((Integer) user.getAccess_level()) {
            case 0: // writer
            case 1: // leader
                return "admin/eventsPage";
            default:
                return "eventsPage";
        }
    }

    @GetMapping("/eventsRegistrationPage/{id}")
    public String registration(Model model, @PathVariable String id) {
        Long idLong = Long.parseLong(id);
        Iterable<Event> event = eventRepository.findAllById(Collections.singleton(idLong));
        model.addAttribute("event", event);
        return "eventsRegistrationPage";
    }

    @GetMapping("/edit")
    public String editGetEvents(@RequestParam("id") Long id, Model model){
        if (user.getAccess_level() == null){  // проверка роли
            return "redirect:/events";
        }

        Iterable<Event> events = eventRepository.findAllById(Collections.singleton(id));
        model.addAttribute("events", events);
        model.addAttribute("title", "Редактирование мероприятий");

        return "admin/eventsEditPage";
    }

    @PostMapping("/eventsRegistrationPage/{id}")
    public String check_form(@RequestParam("name") String input_name,
                             @RequestParam("vk") String input_vk, @PathVariable("id") String id,
                             Model model) throws ClassNotFoundException, SQLException
    {

        if (user.getAccess_level() != null){  // проверка роли
            /*System.out.println("You entered : "+ input_name + ", " + input_vk + "," + id);*/

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            Statement statement = connection.createStatement();

            Integer idInt = Integer.parseInt(id);

            String sql_update = "INSERT INTO registration (name, vk, id) VALUES ("
                    + "'" + input_name + "'" + ","
                    + "'" + input_vk + "'" + ","
                    + "'" + idInt + "'" +
                    ")";
        /*String sql_query = "SELECT * FROM registration";
        statement.executeUpdate(sql_update);
        ResultSet resultSet = statement.executeQuery(sql_query);
        while (resultSet.next()) {
            System.out.print(resultSet.getString("name") + " ");
            System.out.print(resultSet.getString("vk") + " ");
            System.out.print(resultSet.getString("id") + " ");
        }*/

        }

        return "redirect:/events";
    }

    @PostMapping("")
    public String addEvents(@RequestParam("title") String title,
                          @RequestParam("text") String text,
                          @RequestParam("date") String date,
                          Model model) {

        if (user.getAccess_level() != null){  // проверка роли
            Event event = new Event(title, text, date);
            eventRepository.save(event);
        }

        return "redirect:/events";
    }

    @PostMapping("/edit")
    public String editEvents(@RequestParam("id") Long id,
                           @RequestParam("title") String title,
                           @RequestParam("text") String text,
                           @RequestParam("date") String date,
                           Model model){

        if (user.getAccess_level() != null){  // проверка роли
            if(eventRepository.existsById(id)) {
                Event event = new Event(id, title, text, date);
                eventRepository.save(event);
            }
        }

        return "redirect:/events";
    }

    @PostMapping("/delete")
    public String deleteEvents(@RequestParam("id") Long id,
                             Model model){

        if (user.getAccess_level() != null){  // проверка роли
            if(eventRepository.existsById(id)) {
                eventRepository.deleteById(id);
            }
        }

        return "redirect:/events";
    }


}
