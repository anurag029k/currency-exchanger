package com.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {

    @Autowired
    private Currency_Converter converter;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("Currency", converter.Currency);
        return "index";
    }

    @PostMapping("/convert")
    public String convert(
            @RequestParam int Response,
            @RequestParam String cr1,
            @RequestParam String cr2,
            @RequestParam(defaultValue = "0") int amt,
            Model model) {

        model.addAttribute("Currency", converter.Currency);
        model.addAttribute("cr1", cr1);
        model.addAttribute("cr2", cr2);
        model.addAttribute("Response", Response);

        if (Response == 1) {
            double result = converter.checkRate(cr1, cr2);
            if (result == -1)
                model.addAttribute("error", "Invalid currency code.");
            else
                model.addAttribute("result",
                        "1 " + cr2 + " ->  VALUE IN " + cr1 + " = " + result);

        } else if (Response == 2) {
            double result = converter.convert(cr1, cr2, amt);
            if (result == -1)
                model.addAttribute("error", "Invalid currency code.");
            else
                model.addAttribute("result",
                        "from " + cr2 + " ->  to " + cr1 + " = " + result);
        }

        return "index";
    }
}