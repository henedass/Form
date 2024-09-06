package com.example.hw;

import com.example.hw.User;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }

        // Convert String to Date
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            Date date = sdf.parse(user.getBirthday());
            model.addAttribute("user", user);
            model.addAttribute("parsedDate", date);
        } catch (ParseException e) {
            result.rejectValue("birthday", "error.user", "Invalid date format");
            return "form";
        }

        return "result";
    }
}
