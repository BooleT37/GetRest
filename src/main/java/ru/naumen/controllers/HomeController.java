package ru.naumen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naumen.model.Storage;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by dkirpichenkov on 31.10.16.
 */
@Controller
@Named
public class HomeController {

    @Inject @Named("fileStorage")
    private Storage storage;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "World");
        model.addAttribute("allItems", storage.getAllData());
        return "index";
    }
}
