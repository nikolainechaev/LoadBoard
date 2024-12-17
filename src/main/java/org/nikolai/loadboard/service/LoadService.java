package org.nikolai.loadboard.service;

import org.nikolai.loadboard.entity.Carrier;
import org.nikolai.loadboard.entity.Load;
import org.nikolai.loadboard.entity.LoadStatus;
import org.nikolai.loadboard.repository.CarrierRepository;
import org.nikolai.loadboard.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    private final LoadRepository loadRepository;
    private final CarrierRepository carrierRepository;

    public LoadService(LoadRepository loadRepository, CarrierRepository carrierRepository) {
        this.loadRepository = loadRepository;
        this.carrierRepository = carrierRepository;
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Optional<Load> getLoadById(Long id) {
        return loadRepository.findById(id);
    }

    public Load createLoad(Load load) {
        load.setStatus(LoadStatus.AVAILABLE);
        return loadRepository.save(load);
    }

    public void deleteLoad(Long id) {
        loadRepository.deleteById(id);
    }

    public Load assignCarrierToLoad(Long loadId, Long carrierId) {
//        Load load = loadRepository.findById(loadId)
//                .orElseThrow(() -> new RuntimeException("Load not found"));
//
//        Carrier carrier = carrierRepository.findById(carrierId)
//                .orElseThrow(() -> new RuntimeException("Carrier not found"));
//
//        load.setAssignedCarrier(carrier);
//        load.setStatus(LoadStatus.PICKED_UP);
//        return loadRepository.save(load);
        // Find the load by ID
        Load load = loadRepository.findById(loadId)
                .orElseThrow(() -> new RuntimeException("Load not found"));

        // Check if the load is already assigned to a carrier
        if (load.getAssignedCarrier() != null) {
            throw new RuntimeException("Load is already assigned to a carrier");
        }

        // Find the carrier by ID
        Carrier carrier = carrierRepository.findById(carrierId)
                .orElseThrow(() -> new RuntimeException("Carrier not found"));

        // Assign the carrier to the load
        load.setAssignedCarrier(carrier);
        load.setStatus(LoadStatus.PICKED_UP);

        // Save and return the updated load
        return loadRepository.save(load);
    }

    public Load updateLoadStatus(Long loadId, LoadStatus status) {
        Load load = loadRepository.findById(loadId)
                .orElseThrow(() -> new RuntimeException("Load not found"));

        load.setStatus(status);
        return loadRepository.save(load);
    }
    public Load updateLoad(Long id, Load updatedLoad) {
        return loadRepository.findById(id).map(load -> {
            load.setOrigin(updatedLoad.getOrigin());
            load.setDestination(updatedLoad.getDestination());
            load.setCargoType(updatedLoad.getCargoType());
            load.setWeight(updatedLoad.getWeight());
            return loadRepository.save(load);
        }).orElseThrow(() -> new RuntimeException("Load not found"));
    }

}
