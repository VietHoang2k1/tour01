package com.example.tourdb.controller;

import com.example.tourdb.model.Destination;
import com.example.tourdb.service.DestinationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/destinations")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping
    public String getAllDestinations(Model model) {
        model.addAttribute("destinations", destinationService.findAll());
        return "destination/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("destination", new Destination());
        return "destination/form";
    }
    @PostMapping
    public String createDestination(@ModelAttribute("destination") Destination destination) {
        destinationService.save(destination);
        return "redirect:/admin/destinations";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Destination destination = destinationService.findById(id);
        model.addAttribute("destination", destination);
        return "destination/form";
    }
    @PostMapping("/{id}")
    public String updateDestination(@PathVariable Long id, @ModelAttribute("destination") Destination destination) {
        Destination existing = destinationService.findById(id);
        existing.setName(destination.getName());
        existing.setDescription(destination.getDescription());
        existing.setLocation(destination.getLocation());
        existing.setImageUrl(destination.getImageUrl());
        existing.setVideoUrl(destination.getVideoUrl()); // Cập nhật video URL
        destinationService.save(existing);
        return "redirect:/admin/destinations";
    }
    @GetMapping("/{id}")
    public String viewDestinationDetails(@PathVariable Long id, Model model) {
        Destination destination = destinationService.findById(id);
        model.addAttribute("destination", destination);
        return "destination/details";
    }

    @GetMapping("/{id}/delete")
    public String deleteDestination(@PathVariable Long id) {
        destinationService.deleteById(id);
        return "redirect:/admin/destinations";
    }
}