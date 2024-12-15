package org.nikolai.loadboard.service;

import org.nikolai.loadboard.entity.Carrier;
import org.nikolai.loadboard.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierService {
    private final CarrierRepository carrierRepository;

    public CarrierService(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }
    public Carrier createCarrier(Carrier carrier) {
        return carrierRepository.save(carrier);
    }
    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

}
