package com.mycompany.springbootproject.service;

import com.mycompany.springbootproject.model.Flight;

import java.util.List;

public interface FlightService {

    public List<Flight> getAll();

    public Flight addFlight(Flight flight);

    public Flight fetchById(int id);

    public void updateFlight(int id, Flight flight);

    public void deleteFlight(int id);
}
