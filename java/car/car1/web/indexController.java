package car.car1.web;

import car.car1.Information;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class indexController {
    @GetMapping("/index")
    public String menu() {
        return "index";
    }


}