package org.nikolai.loadboard.controller;

import org.nikolai.loadboard.entity.Load;
import org.nikolai.loadboard.entity.LoadStatus;
import org.nikolai.loadboard.service.LoadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loads")
public class LoadController {

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @GetMapping
    public List<Load> getAllLoads() {
        return loadService.getAllLoads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long id) {
        return loadService.getLoadById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Load createLoad(@RequestBody Load load) {
        return loadService.createLoad(load);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long id, @RequestBody Load updatedLoad) {
        try {
            return ResponseEntity.ok(loadService.updateLoad(id, updatedLoad));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/assign-carrier")
    public ResponseEntity<Load> assignCarrierToLoad(
            @PathVariable Long id,
            @RequestParam Long carrierId) {
        try {
            return ResponseEntity.ok(loadService.assignCarrierToLoad(id, carrierId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoad(@PathVariable Long id) {
        loadService.deleteLoad(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Load> updateLoadStatus(
            @PathVariable Long id,
            @RequestParam LoadStatus status) {
        try {
            return ResponseEntity.ok(loadService.updateLoadStatus(id, status));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
