package cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BabysitterController {
    @GetMapping("/sitter")
    public String getSitter() {
        return "/sitter/sitter";
    }
    @GetMapping("/provider")
    public String getProvider(){
        return "/sitter/provider";
    }
}
