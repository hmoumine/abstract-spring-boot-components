package org.example.codefox.domainpole.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Entity(name = "organization")
@Getter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrganizationEntity extends BaseEntity {

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Collection<GroupEntity> groups;

    @OneToOne(cascade = CascadeType.ALL)
    private ServiceEntity service;

}
