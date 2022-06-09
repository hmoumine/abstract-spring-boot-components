package org.example.codefox.domainpole.repositories;

import org.example.codefox.domainpole.entities.ZipCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCodeEntity, UUID> {
}
