package cat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cat.service.BabysitterResultService;

@Controller
public class BabysitterResultController {
    @Autowired
    BabysitterResultService service;
    @GetMapping("/result")
    public String getTime(Model model) {
        model.addAttribute("dateList", service.selectBabysitterResultDates());

        return "/main/result";
    }
}
