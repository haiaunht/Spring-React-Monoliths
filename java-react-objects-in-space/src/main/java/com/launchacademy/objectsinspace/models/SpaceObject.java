package com.launchacademy.objectsinspace.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="space_objects")
@Getter
@Setter
@NoArgsConstructor
public class SpaceObject {
  @Id
  @SequenceGenerator(name="space_object_generator", sequenceName="space_objects_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="space_object_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @Size(max=100)
  @Column
  private String name;

  @NotBlank
  @Column
  private String ngc;

  @Min(1)
  @Column(name="year_discovered")
  private Integer yearDiscovered;
}
