package ru.sfu.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.sfu.dao.BagDAO;
import ru.sfu.models.Bag;

@Controller
@RequestMapping("/bags")
public class BagsController {
    private final BagDAO bagDAO;

    @Autowired
    public BagsController(BagDAO bagDAO) {
        this.bagDAO = bagDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("bags", bagDAO.index());
        return "bags/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("bag", bagDAO.show(id));
        return "bags/show";
    }

    @GetMapping("/new")
    public String newBag(@ModelAttribute("bag") Bag bag) {
        return "bags/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("bag") @Valid Bag bag,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "bags/new";

        bagDAO.insert(bag);
        return "redirect:/bags";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("bag", bagDAO.show(id));
        return "bags/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("bag") @Valid Bag bag,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "bags/edit";

        bagDAO.update(id, bag);
        return "redirect:/bags";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bagDAO.delete(id);
        return "redirect:/bags";
    }
}
