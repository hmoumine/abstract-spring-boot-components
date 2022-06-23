package org.example.codefox.domaintitleprincipals.repositories;

import org.example.codefox.domaintitleprincipals.model.TitlePrincipals;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface {@code TitlePrincipalsRepository} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

@Repository
public interface TitlePrincipalsRepository extends ReactiveMongoRepository<TitlePrincipals, UUID> {
}
