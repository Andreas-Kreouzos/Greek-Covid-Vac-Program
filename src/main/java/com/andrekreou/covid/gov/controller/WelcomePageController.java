package com.andrekreou.covid.gov.controller;

import com.andrekreou.covid.gov.model.Covid;
import com.andrekreou.covid.gov.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomePageController {

    private final ServiceProvider service;

    @Autowired
    public WelcomePageController(ServiceProvider service) {
        this.service = service;
    }

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("message", message);
        return "welcome";
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping("/date/insert")
    public String getDateInsertView(Model model) {
        model.addAttribute("covid",new Covid());
        return "date-insert";
    }

    @GetMapping("/show-contents")
    public String showAllRates(HttpServletRequest request){
        request.setAttribute("covidcases", service.showAllCases());
        return "databasecontents";
    }

    @RequestMapping(value = "/dateInsertion", method = RequestMethod.POST)
    public String submit(@ModelAttribute("covid") Covid covid,
                         Model model,
                         HttpServletRequest request) {
        model.addAttribute("referencedate", covid.getReferencedate());
        request.setAttribute("covidcases", service.showCases(covid.getReferencedate()));
        return "databasecontents";
    }
}