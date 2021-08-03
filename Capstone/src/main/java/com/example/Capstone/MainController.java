package com.example.Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
        model.addAttribute("monlist", pokerepo.findAll());

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
    public String processPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        if (result.hasErrors()) {
            return "pokecreate";
        }

        pokemon.setCreator(creatorId);

        pokerepo.save(pokemon);

        return "redirect:/pokemon_view";
    }

    @GetMapping("/edit_pokemon/{id}")
    public String showPokeUpdateForm(@PathVariable("id") Long id, Model model) {
        Pokemon pokemon = pokerepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pokemon Id:" + id));

        model.addAttribute("pokemon", pokemon);
        model.addAttribute("abilityList", abilityRepo.findAll());
        return "edit_pokemon";
    }

    @PostMapping("/edit_success/{id}")
    public String updatePokemon(@PathVariable Long id, @Valid Pokemon pokemon,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            pokemon.setId(id);
            return "edit_pokemon";
        }



        pokerepo.save(pokemon);
        return "redirect:/pokemon_view";
    }

    @GetMapping("/delete_pokemon/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        Pokemon pokemon = pokerepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pokemon Id:" + id));
        pokerepo.delete(pokemon);
        return "redirect:/pokemon_view";
    }

    @GetMapping("/pokemon_view")
    public String displayPokemon(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        model.addAttribute("monlist", pokerepo.findMonByUserId(creatorId));

        return "pokeView";
    }

    @GetMapping("/pokemon_detail_view/{id}")
    public String displayPokemonDetails(@PathVariable(required = false) Long id, Model model, RedirectAttributes redirAttrs){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        if (id == null) {
            redirAttrs.addFlashAttribute("error", "Pokémon not found!");
            return "redirect:/pokeView";
        }
        else {
            model.addAttribute("pokemon", pokerepo.findMonById(id));
        }

        return "pokeDetailView";
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

}
