package cat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.service.SitterService;
import cat.vo.SitterVO.MapInfoVO;

@Controller
public class BabysitterController {
    @Autowired
    SitterService service;
    @GetMapping("/sitter")
    public String getSitter(@RequestParam Integer seq, Model model) {
        MapInfoVO vo = service.selectMap(seq);
        
        model.addAttribute("data", vo);
        
        return "/sitter/sitter";
    }
    @GetMapping("/provider")
    public String getProvider(){
        return "/sitter/provider";
    }
}
