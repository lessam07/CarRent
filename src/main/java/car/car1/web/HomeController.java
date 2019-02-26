package car.car1.web;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;


import car.car1.Taco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import car.car1.Information;
@Slf4j
@Controller

@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String showDesignForm(Model model) {
        model.addAttribute("Information", new Information());
        return "home";
    }
    @PostMapping
    public String processDesign(@Valid @ModelAttribute("Information") Information information, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "home";
        }
        return "orderForm";
    }
}
