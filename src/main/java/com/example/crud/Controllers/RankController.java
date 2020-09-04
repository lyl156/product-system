package com.example.crud.Controllers;

import com.example.crud.Services.Rank.RankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RankController {
    private RankService rankService;

    public RankController(RankService rankService) {
        this.rankService = rankService;
    }

    @RequestMapping(value = "rank", method = RequestMethod.GET)
    public String getRank(Model model) {
        model.addAttribute("ranks", rankService.getTopRank());
        return "rank";
    }
}
