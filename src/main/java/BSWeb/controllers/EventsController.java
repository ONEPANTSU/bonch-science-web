package BSWeb.controllers;

import BSWeb.models.Event;
import BSWeb.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

@Controller
public class EventsController {

    @Value("${spring.datasource.url}")
    private String db_url;
    @Value("${spring.datasource.username}")
    private String db_username;
    @Value("${spring.datasource.password}")
    private String db_password;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events")
    public String registration(Model model) {
        Iterable<Event> event = eventRepository.findAll();
        model.addAttribute("event", event);
        model.addAttribute("name","Мероприятия");
        return "eventsPage";
    }

    @PostMapping("/events")
    public String check_form(@RequestParam("name") String input_name,
                             @RequestParam("vk") String input_vk,
                             Model model) throws ClassNotFoundException, SQLException
    {
        System.out.println("You entered : "+ input_name + ", " + input_vk);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
        Statement statement = connection.createStatement();

        String sql_update = "INSERT INTO registration (name, vk) VALUES (" + "'" + input_name + "'" + "," + "'"
                                                                        + input_vk + "'" + ")";
        String sql_query = "SELECT * FROM registration";
        statement.executeUpdate(sql_update);
        ResultSet resultSet = statement.executeQuery(sql_query);
        /*while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("vk"));
        }*/


        return "redirect:/events";
    }


}
