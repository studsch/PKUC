package main.controllers;

import javax.validation.Valid;

import main.Bag;
import main.BagDao;

import main.User;
import main.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BagController {

    private final BagDao bagDao;

    private double filterCost = 0;

    @Autowired
    public BagController(BagDao bagDao) {
        this.bagDao = bagDao;
    }

    @GetMapping("/add_bag")
    public String newPerson(Model model) {
        model.addAttribute("bag", new Bag());
        return "add_bag";
    }

    @PostMapping("/add_bag")
    public String createBag(@ModelAttribute("bag") @Valid Bag bag, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/add_bag";
        }
        for (Bag bag_i : bagDao.findAll()) {
            if (bag_i.getId() == bag.getId())
                return "redirect:/add_bag";
        }
        this.bagDao.insert(bag);
        return "redirect:/";
    }

    @GetMapping("/show_all")
    public String findAll(Model model) {
        model.addAttribute("bags", bagDao.findAll());
        return "show_all";
    }

    @GetMapping("/edit_bag")
    public String edit(Model model) {
        model.addAttribute("bag", new Bag());
        return "edit_bag";
    }

    @PatchMapping("/edit_bag")
    public String update(@ModelAttribute("bag") @Valid Bag bag, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_bag";
        }
        bagDao.update(bag);
        return "redirect:/";
    }

    @GetMapping("/delete_bag")
    public String delete_get(Model model) {
        int id = 0;
        model.addAttribute("id", id);
        return "delete_bag";
    }

    @DeleteMapping("/delete_bag")
    public String delete(@RequestParam("id") int id) {
        bagDao.delete(id);
        return "redirect:/";
    }

    @GetMapping("/filter_show")
    public String filter_form(Model model) {
        double cost = filterCost;
        model.addAttribute("cost", cost);
        model.addAttribute("bags", bagDao.findAllCostIncreaseThan(filterCost));
        filterCost = 0;
        return "filter_show";
    }

    @PostMapping("/filter_show")
    public String filter_post(@RequestParam("cost") double cost, Model model) {
        filterCost = cost;
        return "redirect:/filter_show";
    }
}