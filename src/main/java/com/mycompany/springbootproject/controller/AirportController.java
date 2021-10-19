package com.mycompany.springbootproject.controller;
import com.mycompany.springbootproject.model.Airport;
import com.mycompany.springbootproject.service.AirportService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//RESTful APIs
@Slf4j // It offers a generic API making the logging independent of the actual implementation.
@Controller // allows us to auto-detect implementation classes through the classpath scanning.
@ResponseBody // tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
@RequestMapping("api/v1.0/flight/stock") // the annotation is used to map web requests to Spring Controller methods.
public class AirportController {

    @Autowired // Enabling annotation injection, we can use autowiring on properties, setters, and constructors.
    private AirportService airportService;

    @GetMapping("/getall") // annotation that acts as a shortcut for @RequestMapping.
    @ApiOperation("Fetch All Flight Routes") // annotation to describe the endpoint and its response type
    public List<Airport> getEmployees() {
        return airportService.getAll();
    }

    @ApiOperation("Save a New Flight Route") // annotation to describe the endpoint and its response type
    @PostMapping("/add/{flightId}") // Annotation for mapping HTTP POST requests onto specific handler methods.
    public ResponseEntity<Airport> createFlightRoute(@Valid @RequestBody Airport airport, @PathVariable int flightId) {
        Airport cust = airportService.addFlight(airport,flightId);
        return new ResponseEntity<>(cust, HttpStatus.CREATED);
    }

    @ApiOperation("Get A Employee By ID") // annotation to describe the endpoint and its response type
    @GetMapping("/getbyid/{id}")  // annotation that acts as a shortcut for @RequestMapping.
    public Airport fetchById(@PathVariable int id) {
        return airportService.fetchById(id);
    }

    @ApiOperation("Delete A Route")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        log.info("Deleting a flight record with id %d", id);
        airportService.deleteFlight(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}