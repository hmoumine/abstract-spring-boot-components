package org.example.codefox.domaintitleakas.repository;

import org.example.codefox.domaintitleakas.model.AlsoKnownAs;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

/**
 * Class {@code AlsoKnownAsRepository} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public interface AlsoKnownAsRepository extends ReactiveMongoRepository<AlsoKnownAs, UUID> {
}
