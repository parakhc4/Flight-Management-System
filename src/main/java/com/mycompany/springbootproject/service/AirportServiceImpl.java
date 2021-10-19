package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Airport;
import com.mycompany.springbootproject.repository.AirportRepository;
import com.mycompany.springbootproject.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport addFlight(Airport airport, int id) {
        airport.setFlight_No(id);
        airportRepository.save(airport);
        return airport;
    }

    @Override
    public Airport fetchById(int id) {
        Airport airport = null;
        Optional<Airport> optionalFlight = airportRepository.findById(id);
        if (optionalFlight.isPresent())
        {
            airport = optionalFlight.get();
        }
        return airport;
    }

    @Override
    public void updateFlight(int id, Airport airport) {
        Airport tempFlight = null;
        Optional<Airport> optionalFlight = airportRepository.findById(id);
        if (optionalFlight.isPresent())
        {
            tempFlight = optionalFlight.get();
        }
        tempFlight.setFlight_No(airport.getFlight_No());
        tempFlight.setAirline(airport.getAirline());
        tempFlight.setCost(airport.getCost());
        tempFlight.setInstruments(airport.getInstruments());
        tempFlight.setMeal_Availability(airport.getMeal_Availability());
        tempFlight.setRows(airport.getRows());
        tempFlight.setDestination_Airport(airport.getDestination_Airport());
        tempFlight.setSource_Airport(airport.getSource_Airport());
    }

    @Override
    public void deleteFlight(int id) {
        airportRepository.deleteById(id);
    }
}
