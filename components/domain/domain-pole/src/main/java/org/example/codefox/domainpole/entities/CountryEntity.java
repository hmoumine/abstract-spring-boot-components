package org.example.codefox.domainpole.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.HashSet;

@Entity(name = "country")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CountryEntity extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CityEntity> cities = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<DepartmentEntity> departments = new HashSet<>();
}
