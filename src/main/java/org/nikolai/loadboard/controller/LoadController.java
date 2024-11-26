package org.nikolai.loadboard.controller;

import org.nikolai.loadboard.entity.Load;
import org.nikolai.loadboard.entity.User;
import org.nikolai.loadboard.service.LoadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loads")
public class LoadController {
    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @GetMapping("/available")
    public List<Load> getAvailableLoads() {
        return loadService.findAllAvailableLoads();
    }

    @PostMapping
    public Load postLoad(@RequestBody Load load) {
        return loadService.postLoad(load);
    }

    @PutMapping("/{id}/book")
    public Load bookLoad(@PathVariable Long id, @RequestBody User user) {
        return loadService.bookLoad(id, user);
    }
}

