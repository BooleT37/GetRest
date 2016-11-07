package ru.naumen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.model.HashMapStorage;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
@Controller
public class HomeController {

    private HashMapStorage storage = HashMapStorage.getInstance();

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "World");
        model.addAttribute("allItems", storage.getAllData());
        return "index";
    }
}
