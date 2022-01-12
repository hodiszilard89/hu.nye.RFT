package com.example.hunyerft.controller;


import com.example.hunyerft.domain.User;
import com.example.hunyerft.domain.Vizsga;
import com.example.hunyerft.service.UserService;
import com.example.hunyerft.service.VizsgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {


    private UserService userService;

    @Autowired

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private Authentication auth;

    private VizsgaService vizsgaService;
    @Autowired
    public void setVizsgaService(VizsgaService vizsgaService) {
        this.vizsgaService = vizsgaService;
    }

    @RequestMapping("/gohome")
    public String gohome(Model model){
        return "/home";
    }

    @RequestMapping("/")
    public String root(Model model){

        return "home";
    }

    @GetMapping("/hallgato")
    public String hallgato(Model model){
        auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("vizsgak",
                userService.getVizsgak(userService.findByNev(auth.getName())) );

        return "hallgato";
    }


    @RequestMapping("/oktato")
    public String oktato(Model model){
        model.addAttribute("vizsga",new Vizsga());
        model.addAttribute("vizsgak",vizsgaService.getVizsgak() );

        return "oktato";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Vizsga vizsga){

        vizsgaService.init(vizsga);
        return "redirect:/oktato";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name="id")Long id){
        vizsgaService.deleteVizsga(vizsgaService.getVizsga(id));

        return "redirect:/oktato";
    }


    @GetMapping("/vizsgafelvetel/{id}")
    public String vizsgafelvetel(@PathVariable(name="id")Long id){
        auth = SecurityContextHolder.getContext().getAuthentication();
        userService.addVizsga(userService.findByNev(auth.getName()),vizsgaService.getVizsga(id));
        return "redirect:/oktato";
    }

    @GetMapping("/deletehallgato/{id}")
    public String deletehallgato(@PathVariable(name="id")Long id){
        auth = SecurityContextHolder.getContext().getAuthentication();
        User u=userService.findByNev(auth.getName());
        userService.deleteFelvettVizsga(u,vizsgaService.getVizsga(id));

        return "redirect:/hallgato";
    }
}
