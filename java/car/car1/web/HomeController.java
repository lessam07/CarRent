package car.car1.web;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import car.car1.InformationRepository;
import car.car1.Information;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@Controller

@RequestMapping("/")
public class HomeController {
    private InformationRepository infoRepo;
    public HomeController(InformationRepository infoRepo) {
        this.infoRepo = infoRepo;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Information information) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid Information information, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        infoRepo.save(information);
        model.addAttribute("info", infoRepo.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Information information = infoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("info", information);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid Information information,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            information.setId(id);
            return "update-user";
        }

        infoRepo.save(information);
        model.addAttribute("info", infoRepo.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        Information information = infoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        infoRepo.delete(information);
        model.addAttribute("info", infoRepo.findAll());
        return "index";
    }

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
        infoRepo.save(information);
        return "redirect:services";
    }
}
