package com.mycompany.springbootproject.controller;

import com.mycompany.springbootproject.model.Flight;
import com.mycompany.springbootproject.service.FlightService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//RESTful APIs
@Slf4j // It offers a generic API making the logging independent of the actual implementation.
@Controller // allows us to auto-detect implementation classes through the classpath scanning.
@ResponseBody // tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
@RequestMapping("api/v1.0/flight/booking") // the annotation is used to map web requests to Spring Controller methods.
public class FlightController {

    @Autowired // Enabling annotation injection, we can use autowiring on properties, setters, and constructors.
    private FlightService flightService;

    @ApiOperation("Save a New Flight Record!") // annotation to describe the endpoint and its response type
    @PostMapping("/register") // Annotation for mapping HTTP POST requests onto specific handler methods.
    public ResponseEntity<Flight> createFlight(@Valid @RequestBody Flight flight) {
        log.info("Inside Flight %s", flight);
        Flight cust = flightService.addFlight(flight);
        return new ResponseEntity<>(cust, HttpStatus.CREATED);
    }


    @ApiOperation("Get A Flight record By ID") // annotation to describe the endpoint and its response type
    @GetMapping("/getbyid/{id}")  // annotation that acts as a shortcut for @RequestMapping.
    public Flight fetchById(@PathVariable int id) {
            return flightService.fetchById(id);
    }

//    @ApiOperation("Update An Existing Flight")
//    @PutMapping("/update/{id}")
//    public void update(@PathVariable int id,@Valid @RequestBody Flight flight){
//        log.info("Updating a flight!!");
//        flightService.updateFlight(id, flight);
//    }

    @ApiOperation("Delete A Flight Record")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        log.info("Deleting a Flight with id %d", id);
        flightService.deleteFlight(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


