package com.example.tourdb.service;
import com.example.tourdb.model.Destination;
import java.util.List;
public interface DestinationService {
    List<Destination> findAll();
    Destination findById(Long id);
    Destination save(Destination destination);
    void deleteById(Long id);
}