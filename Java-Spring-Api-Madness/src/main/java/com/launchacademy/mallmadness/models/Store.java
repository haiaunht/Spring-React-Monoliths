package com.launchacademy.mallmadness.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "stores")
public class Store {
  @Id
  @SequenceGenerator(name="store_generator", sequenceName="stores_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="store_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull //present
  @Column(name = "name", nullable = false)
  private String name;

  @NotNull //present
  @Column(name = "type", nullable = false)
  private String type;

  @NotNull //present
  @Range(min=1, max=5)
  @Column(name = "average_cost", nullable = false)
  private Integer averageCost;

  @NotNull
  @Column(name = "operating_status", nullable = false)
  private Boolean operatingStatus;
}
