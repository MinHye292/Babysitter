package cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BabysitterTimeController {
    @GetMapping("/requestTime")
    public String getTime() {
        return "/request/request";
    }
}

