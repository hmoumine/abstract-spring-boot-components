package org.example.codefox.domainpole.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.HashSet;

@Entity(name = "city")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CityEntity extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<ZipCodeEntity> zipCodes = new HashSet<>();
}
