package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Airport;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AirportService {

    public List<Airport> getAll();

    public Airport addFlight(Airport airport);

    public Airport fetchById(int id);

    public void updateFlight(int id, Airport airport);

    public void deleteFlight(int id);
}
