package com.mycompany.springbootproject.repository;

import com.mycompany.springbootproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Employee, Integer> {

}
