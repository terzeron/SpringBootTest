package net.terzeron.springboot;

import net.terzeron.springboot.api.facebook.Facebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private Facebook facebook;

    @Autowired
    public HomeController(Facebook facebook) {
        this.facebook = facebook;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("profile", facebook.getProfile());
        model.addAttribute("feed", facebook.getFeed());
        return "home";
    }
}
