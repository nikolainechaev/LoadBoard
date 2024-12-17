package org.nikolai.loadboard.controller;

import org.nikolai.loadboard.entity.Carrier;
import org.nikolai.loadboard.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {
    private final CarrierService carrierService;

    public CarrierController(CarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @GetMapping
    public List<Carrier> getAllCarriers() {
        return carrierService.getAllCarriers();
    }

    @PostMapping
    public Carrier createCarrier(@RequestBody Carrier carrier) {
        return carrierService.createCarrier(carrier);
    }

    @GetMapping("/{id}")
    public Carrier getCarrierById(@PathVariable Long id) {
        return carrierService.getCarrierById(id);
    }
}
