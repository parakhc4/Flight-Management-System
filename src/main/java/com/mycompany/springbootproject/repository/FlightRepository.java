package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.model.Employee;
import com.mycompany.springbootproject.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
