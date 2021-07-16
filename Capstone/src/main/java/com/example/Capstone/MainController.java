package com.example.Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("")
    public String homepage(pokemon pokemon ){
        return "";
    }

    @GetMapping("/pokecreate")
    public String pokecreate(Model model){
        model.addAttribute("pokemon", new pokemon());
        return "pokecreate";
    }
}
