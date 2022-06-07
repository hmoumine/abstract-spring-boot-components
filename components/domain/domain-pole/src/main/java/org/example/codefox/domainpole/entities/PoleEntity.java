package org.example.codefox.domainpole.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.HashSet;

@Entity(name = "pole")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PoleEntity extends BaseEntity {

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<OrganizationEntity> organizations = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private LocationEntity location;
}
