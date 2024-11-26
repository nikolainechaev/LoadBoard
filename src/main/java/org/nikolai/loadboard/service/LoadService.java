package org.nikolai.loadboard.service;

import org.nikolai.loadboard.entity.Load;
import org.nikolai.loadboard.entity.User;
import org.nikolai.loadboard.exception.ResourceNotFoundException;
import org.nikolai.loadboard.repository.LoadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadService {
    private final LoadRepository loadRepository;

    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    /**
     * Retrieve all loads that have not been booked.
     *
     * @return list of available loads
     */
    public List<Load> findAllAvailableLoads() {
        return loadRepository.findByBookedByIsNull();
    }

    /**
     * Retrieve loads booked by a specific user.
     *
     * @param userId ID of the user
     * @return list of booked loads
     */
    public List<Load> findBookedLoads(Long userId) {
        return loadRepository.findByBookedById(userId);
    }

    /**
     * Post a new load to the load board.
     *
     * @param load Load entity to post
     * @return posted Load entity
     */
    public Load postLoad(Load load) {
        return loadRepository.save(load);
    }

    /**
     * Delete a load by its ID.
     *
     * @param loadId ID of the load to delete
     */
    public void deleteLoad(Long loadId) {
        Load load = loadRepository.findById(loadId)
                .orElseThrow(() -> new ResourceNotFoundException("Load not found with ID: " + loadId));
        loadRepository.delete(load);
    }

    /**
     * Book a load by a user.
     *
     * @param loadId ID of the load to book
     * @param user   User booking the load
     * @return the booked Load entity
     */
    public Load bookLoad(Long loadId, User user) {
        Load load = loadRepository.findById(loadId)
                .orElseThrow(() -> new ResourceNotFoundException("Load not found with ID: " + loadId));

        if (load.getBookedBy() != null) {
            throw new RuntimeException("Load already booked.");
        }

        load.setBookedBy(user);
        return loadRepository.save(load);
    }
}
