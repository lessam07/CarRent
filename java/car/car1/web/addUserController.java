package car.car1.web;
import car.car1.Information;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class addUserController {
    @GetMapping("/add-user")
    public String menu(Model model) {
        model.addAttribute("info", new Information());
        return "add-user";
    }
}
