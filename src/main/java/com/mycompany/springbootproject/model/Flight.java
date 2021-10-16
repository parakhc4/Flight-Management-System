package com.mycompany.springbootproject.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name="flightTable")
public class Flight {
    @Id
    @GeneratedValue
    private Integer flight_No;

    @Size(min=2,max=20)
    @NotNull(message = "Enter Airline name")
    private String airline;

    @NotNull
    private LocalDate date;

    @Size(min=2,max=20)
    @NotNull(message = "Enter Destination")
    private String destination_Airport;

    @Size(min=2, max=20)
    @NotNull(message = "Enter Source")
    private String source_Airport;

    @NotNull(message = "Enter Cost")
    private Integer cost;

    @Size(min=2, max=20)
    @NotNull(message = "Enter Cost")
    private String meal_Type;




}
