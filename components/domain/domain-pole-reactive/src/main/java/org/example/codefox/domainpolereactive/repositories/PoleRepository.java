package org.example.codefox.domainpolereactive.repositories;

import org.example.codefox.domainpolereactive.entities.PoleEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PoleRepository extends ReactiveCrudRepository<PoleEntity, UUID> {
}
