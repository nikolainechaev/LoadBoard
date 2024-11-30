package org.nikolai.loadboard.service;

import org.nikolai.loadboard.entity.Load;
import org.nikolai.loadboard.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoadService {

    private final LoadRepository loadRepository;

    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    public Optional<Load> getLoadById(Long id) {
        return loadRepository.findById(id);
    }

    public Load createLoad(Load load) {
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

    public void deleteLoad(Long id) {
        loadRepository.deleteById(id);
    }
}
