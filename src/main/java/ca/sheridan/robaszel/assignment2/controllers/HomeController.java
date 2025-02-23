//Lucas Robaszek 991727191
package ca.sheridan.robaszel.assignment2.controllers;

import ca.sheridan.robaszel.assignment2.databases.DatabaseAccess;
import ca.sheridan.robaszel.assignment2.utilities.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridan.robaszel.assignment2.beans.PasswordRecord;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    private DatabaseAccess databaseAccess;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @GetMapping(value = {"/", "/home"})
    public String index(Model model) {
        model.addAttribute("passwordRecord", new PasswordRecord());
        return "Index";
    }
    @PostMapping("")
    public String addPasswordRecord(Model model, @ModelAttribute PasswordRecord passwordRecord) {
        passwordRecord.setId(randomNumberGenerator.generateID());
        databaseAccess.save(passwordRecord);
        model.addAttribute("passwordRecord", new PasswordRecord());
        model.addAttribute("recordAdded", true);
        return "Index";
    }

    @GetMapping("/view")
    public String viewPasswordRecords(Model model) {
        model.addAttribute("pswdList", databaseAccess.findAll());
        return "View";
    }
    @GetMapping("/search")
    public String getSearchPage(Model model) {
        model.addAttribute("pswdList", new ArrayList<PasswordRecord>());
        model.addAttribute("searched", false);
        return "Search";
    }
    @PostMapping("/search")
    public String search(@RequestParam String title, Model model) {
        model.addAttribute("pswdList", databaseAccess.getPasswordRecordsByTitle(title));
        model.addAttribute("searched", true);
        return "Search";
    }
}
