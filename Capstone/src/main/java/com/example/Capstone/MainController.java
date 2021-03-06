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
import java.util.*;

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
        model.addAttribute("dex", new Pokedex());
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

        return "redirect:/login";
    }

    @PostMapping("/authenticate")
    public String processLogin(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("userlist", userRepo.findAll());
        model.addAttribute("dex", new Pokedex());
        return "userView";
    }

    @GetMapping("/poke_create")
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

    @PostMapping("/upvote_pokemon/{id}")
    public String upvotePokemon(@PathVariable("id") Long id, @Valid User user,
                                @Valid Pokemon pokemon, Model model, RedirectAttributes redirAttrs) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long voterId = customUser.getId();

        Optional<User> existingUserOptional = userRepo.findById(user.getId());
        if (existingUserOptional.isEmpty()) {
            redirAttrs.addFlashAttribute("error", "Pok??mon not found!");
        }

        User existingUser = existingUserOptional.get();

        existingUser.setLikedPokemon(existingUser.getLikedPokemon());

        userRepo.save(existingUser);

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
    public String updatePokemon(@PathVariable Long id, @Valid Pokemon newPokemon,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            newPokemon.setId(id);
            return "edit_pokemon";
        }

        Optional<Pokemon> existingPokemonOptional = pokerepo.findById(newPokemon.getId());
        if (existingPokemonOptional.isEmpty()) {
            return "edit_pokemon";
        }

        Pokemon existingPokemon = existingPokemonOptional.get();
        existingPokemon.setName(newPokemon.getName());
        existingPokemon.setEntry(newPokemon.getEntry());
        existingPokemon.setHeight(newPokemon.getHeight());
        existingPokemon.setWeight(newPokemon.getWeight());
        existingPokemon.setCategory(newPokemon.getCategory());
        existingPokemon.setAbility(newPokemon.getAbility());
        existingPokemon.setGender(newPokemon.getGender());
        existingPokemon.setTypes(newPokemon.getTypes());


        pokerepo.save(existingPokemon);
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
    public String displayPokemon(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();
        model.addAttribute("dex", new Pokedex());
        model.addAttribute("monlist", pokerepo.findMonByUserId(creatorId));

        return "pokeView";
    }

    @GetMapping("/pokemon_detail_view/{id}")
    public String displayPokemonDetails(@PathVariable(required = false) Long id, Model model, RedirectAttributes redirAttrs) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUser = (CustomUserDetails) auth.getPrincipal();
        Long creatorId = customUser.getId();

        if (id == null) {
            redirAttrs.addFlashAttribute("error", "Pok??mon not found!");
            return "redirect:/pokeView";
        } else {
            model.addAttribute("pokemon", pokerepo.findMonById(id));
        }
        model.addAttribute("dex", new Pokedex());
        return "pokeDetailView";
    }

    @GetMapping("/dex_create")
    public String dexcreate(Model model) {
        model.addAttribute("dex", new Pokedex());
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

    @GetMapping("/dex_main_view")
    public String dexView(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        List<Pokedex> dexlist = dexrepo.findAll();
        model.addAttribute("dexlist", dexlist);

        model.addAttribute("dex", new Pokedex());

        return "dexmainview";
    }

    @GetMapping("/dex_detail/{id}")
    public String dexDetail(Model model, @PathVariable(required = false) Long id) {

        if (id == null) {
            return "redirect:/dex_mainview";
        } else {
            Optional<Pokedex> pokedex = dexrepo.findById(id);
            if (pokedex.isEmpty()) {
                return "redirect:/dex_mainview";
            }
            model.addAttribute("pokedex", pokedex.get());
        }
        model.addAttribute("monlist", pokerepo.findAll());

        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);

        List<Pokedex> dexlist = dexrepo.findAll();
        model.addAttribute("dexlist", dexlist);
        model.addAttribute("dex", new Pokedex());
        return "dexdetail";
    }

    @GetMapping("/poke_select/{id}")
    public String pokeSelect(Model model, @PathVariable(required = false) Long id) {
        Pokedex pokedex = dexrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Pokedex: " + id));
        model.addAttribute("monlist", pokerepo.findAll());
        model.addAttribute("pokedex", pokedex);
        return "pokeSelect";
    }

    @PostMapping("/process_adding/{id}")
    public String process_adding( Model model,@Valid Pokedex pokedex) {
        Optional<Pokedex> existingPokedexOptional = dexrepo.findById(pokedex.getId());
        if (existingPokedexOptional.isEmpty()) {
            return "dex_main_view";
        }

        Set<Pokemon> pokemon = new HashSet<>();


        for (var poke : pokedex.pokemonSet) {
            System.out.println(poke);
            pokemon.add(poke);
        }

        Pokedex existingPokedex= existingPokedexOptional.get();
        existingPokedex.setPokemonSet(pokemon);


        System.out.println(pokemon);
        dexrepo.save(existingPokedex);
        return "redirect:/dex_main_view";
    }
}
