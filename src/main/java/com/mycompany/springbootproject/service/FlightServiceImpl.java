package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Flight;
import com.mycompany.springbootproject.repository.FlightRepository;
import com.mycompany.springbootproject.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight addFlight(Flight flight) {
        flightRepository.save(flight);
        return flight;
    }

    @Override
    public Flight fetchById(int id) {
        Flight flight = null;
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent())
        {
            flight = optionalFlight.get();
        }
        return flight;
    }

    @Override
    public void updateFlight(int id, Flight flight) {
        Flight tempFlight = null;
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent())
        {
            tempFlight = optionalFlight.get();
        }
        tempFlight.setFlight_No(flight.getFlight_No());
        tempFlight.setAirline(flight.getAirline());
        tempFlight.setCost(flight.getCost());
        tempFlight.setMeal_Type(flight.getMeal_Type());
        tempFlight.setDestination_Airport(flight.getDestination_Airport());
        tempFlight.setSource_Airport(flight.getSource_Airport());
    }

    @Override
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }
}
