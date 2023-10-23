package com.thy.airport.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FLIGHT")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

  @Id
  @SequenceGenerator(name = "FLIGHT_ID_GENERATOR", sequenceName = "FLIGHT_ID_GEN", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FLIGHT_ID_GENERATOR")
  @Column(name = "ID",unique = true, nullable = false)
  private int id;
  @Column(name = "DEPARTURE_DATE")
  private Date departureDate;
  @Column(name = "ARRIVAL_DATE")
  private Date arrivalDate;

  @Column(name = "PILOT_FIRST_NAME")
  private String pilotFirstName;
  @Column(name = "PILOT_LAST_NAME")
  private String pilotLastName;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "DEPARTURE_AIRPORT_ID")
  private Airport departureAirportId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ARRIVAL_AIRPORT_ID")
  private Airport arrivalAirportId;

}
