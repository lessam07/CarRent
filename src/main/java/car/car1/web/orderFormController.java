package car.car1.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class orderFormController {
    @GetMapping("/current")
public String menu() {
    return "orderForm";
}
}
