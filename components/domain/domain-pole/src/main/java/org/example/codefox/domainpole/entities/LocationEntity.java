package org.example.codefox.domainpole.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "location")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LocationEntity extends BaseEntity {

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    private CityEntity city;

    @OneToOne(cascade = CascadeType.ALL)
    private ZipCodeEntity zipCode;

    @OneToOne(cascade = CascadeType.ALL)
    private CountryEntity country;

    @OneToOne(cascade = CascadeType.ALL)
    private ServiceEntity service;

    @OneToOne(cascade = CascadeType.ALL)
    private DepartmentEntity department;

}
