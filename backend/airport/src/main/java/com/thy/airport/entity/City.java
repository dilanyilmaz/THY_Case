package com.thy.airport.entity;

import com.thy.airport.dto.CountryDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CITY")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class City {
  @Id
  @SequenceGenerator(name = "CITY_ID_GENERATOR", sequenceName = "CITY_ID_GEN", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_ID_GENERATOR")
  @Column(name = "ID",unique = true,nullable = false)
  private int id;

  @Column(name = "NAME")
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COUNTRY_ID")
  private Country country;

}
