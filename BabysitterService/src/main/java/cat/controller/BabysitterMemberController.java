package cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BabysitterMemberController {
    @GetMapping("/member")
    public String getmember() {
        return "/member/member";
    }
}
