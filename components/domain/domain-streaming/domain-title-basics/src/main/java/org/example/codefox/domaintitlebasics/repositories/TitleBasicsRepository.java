package org.example.codefox.domaintitlebasics.repositories;

import org.example.codefox.domaintitlebasics.model.TitleBasics;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface {@code TitleBasicsRepository} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

@Repository
public interface TitleBasicsRepository extends ReactiveMongoRepository<TitleBasics, UUID> {
}
