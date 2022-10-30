package main.controllers;

import javax.validation.Valid;

import main.Bag;
import main.BagDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bags")
public class BagController {
    private final BagDao bagDao;

    public BagController(BagDao bagDao) {
        this.bagDao = bagDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("bags", bagDao.index());
        return "bags/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("bag", bagDao.showId(id));
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

        bagDao.insert(bag);
        return "redirect:/bags";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("bag", bagDao.showId(id));
        return "bags/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("bag") @Valid Bag bag,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "bags/edit";

        bagDao.update(id, bag);
        return "redirect:/bags";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bagDao.delete(id);
        return "redirect:/bags";
    }
}