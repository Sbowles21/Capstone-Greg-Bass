package com.example.Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    pokeRepo pokerepo;

    @Autowired
    AbilityRepo abilityRepo;

    @Autowired
    dexRepo dexrepo;

    @GetMapping("")
    public String homepage(Model model) {
        model.addAttribute("dex",new Pokedex());
        return "main";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @PostMapping("/process_signup")
    public String processSignup(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "redirect:/";
    }

    @PostMapping("/authenticate")
    public String processLogin(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "redirect:/";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/pokecreate")
    public String pokecreate(Model model) {
        model.addAttribute("abilityList", abilityRepo.findAll());
        model.addAttribute("pokemon", new Pokemon());


        return "pokecreate";
    }

    @PostMapping("/process_pokemon")
    public String processPokemon(Pokemon pokemon) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        pokemon.setCreator(creatorId);

        pokerepo.save(pokemon);

        return "redirect:/";
    }

    @GetMapping("/dexcreate")
    public String dexcreate(Model model) {
    model.addAttribute("dex",new Pokedex());
    return "dexcreate";
    }

    @PostMapping("/process_dex")
    public String processDex(Pokedex dex) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        User creator = userRepo.findByUserId(creatorId);
        dex.setCreator(creator);

        dexrepo.save(dex);

        return "redirect:/";
    }
    @GetMapping("/dexmainview")
    public String dexview(Model model){
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        List<Pokedex> dexlist = dexrepo.findAll();
        model.addAttribute("dexlist", dexlist);
        return "dexmainview";
    }

    @GetMapping("/dexdetail")
    public String dexdetail(Model model){

        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        List<Pokedex> dexlist = dexrepo.findAll();
        model.addAttribute("dexlist", dexlist);

        return "dexdetail";
    }
    @GetMapping("/pokemon_view")
    public String displayPokemon(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        model.addAttribute("monlist", pokerepo.findMonByUserId(creatorId));

        return "pokeView";
    }

    @GetMapping("/pokemon_detail_view")
    public String displayPokemonDetails(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        model.addAttribute("pokemon", pokerepo.findMonById(creatorId));

        return "pokeDetailView";
    }

}
