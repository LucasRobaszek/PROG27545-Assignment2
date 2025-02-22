package ca.sheridan.robaszel.assignment2.controllers;

import ca.sheridan.robaszel.assignment2.databases.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pswdList", databaseAccess.findAll());
        return "index";
    }
}
