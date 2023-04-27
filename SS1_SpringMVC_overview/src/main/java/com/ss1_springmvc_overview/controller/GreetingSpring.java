package com.ss1_springmvc_overview.controller;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller

public class GreetingSpring {
    @GetMapping("/GreetingSpring")
    public String greeting(){
        return "/GreetingSpring";
    }
    @RequestMapping(value = "/currency_transfer", method= RequestMethod.GET)
    public String transferMoney(@RequestParam (defaultValue = "0") String usd, Model model) throws IOException {
        float usd1 = Float.parseFloat(usd);
        float total = usd1 * 23000;
        model.addAttribute("usd1", usd1);
        model.addAttribute("total", total);
        return "/currencyTransfer";
    }
    @RequestMapping(value = "/dictionary", method= RequestMethod.GET)
    public String findWord(@RequestParam (defaultValue = "0")String english, Model model) throws IOException {
        String[] wordsEnlish = { "banana", "apple", "coconut", "orange" };
        String[] wordsVietnamese = { "chuối", "táo", "dừa", "cam" };
        String msg = "not found";
        model.addAttribute("word", english);

        for (int i = 0; i < wordsEnlish.length; i++) {

            if (wordsEnlish[i].equals(english)){
                model.addAttribute("vietnamese", wordsVietnamese[i]);
                break;
            }
            else {
                model.addAttribute("vietnamese", msg);
            }
        }
        return "/dictionary";
    }
}
