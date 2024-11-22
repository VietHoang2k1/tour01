package com.example.tourdb.service.impl;
import com.example.tourdb.model.Destination;
import com.example.tourdb.repository.DestinationRepository;
import com.example.tourdb.service.DestinationService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DestinationServiceImpl implements DestinationService {
    private final DestinationRepository destinationRepository;
    public DestinationServiceImpl(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }
    @Override
    public List<Destination> findAll() {
        return destinationRepository.findAll();
    }
    @Override
    public Destination findById(Long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found"));
    }
    @Override
    public Destination save(Destination destination) {
        return destinationRepository.save(destination);
    }
    @Override
    public void deleteById(Long id) {
        destinationRepository.deleteById(id);
    }
}