package cat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain() {
        return "/index";
    }
    @GetMapping("/login")
    public String getLogin() {
        return "/member/login";
    }
    @GetMapping("/join")
    public String getJoin() {
        return "/member/join";
    }
    @GetMapping("/member/logout")
    public String getLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/main")
    public String getMain1() {
        return "/main/main";
    }
}