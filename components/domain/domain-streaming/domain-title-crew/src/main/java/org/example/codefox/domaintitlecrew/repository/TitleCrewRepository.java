package org.example.codefox.domaintitlecrew.repository;

import org.example.codefox.domaintitlecrew.model.TitleCrew;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

/**
 * Interface {@code TitleCrewRepository} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

public interface TitleCrewRepository extends ReactiveMongoRepository<TitleCrew, UUID> {
}
