package org.example.codefox.domaintitleratings.repository;

import org.example.codefox.domaintitleratings.model.TitleRatings;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

/**
 * Interface {@code TitleRatingsRepository} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

public interface TitleRatingsRepository extends ReactiveMongoRepository<TitleRatings, UUID> {
}
