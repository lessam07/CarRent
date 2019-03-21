package car.car1.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
//end::baseClass[]
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//tag::baseClass[]
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import car.car1.Order;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/order")
    public String orderForm(Model model) {
        model.addAttribute("Order", new Order());
        return "orderForm";
    }
    @PostMapping
    public String processOrder(@Valid @ModelAttribute("Order") Order order, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        return "redirect:services";
    }


//tag::baseClass[]

}
//end::baseClass[]
