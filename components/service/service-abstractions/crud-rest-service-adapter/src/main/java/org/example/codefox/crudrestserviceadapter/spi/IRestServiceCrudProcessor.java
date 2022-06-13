package org.example.codefox.crudrestserviceadapter.spi;

import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;

import java.util.Optional;

/**
 * Interface {@code ICrudServicePort} provides [...]
 *
 * @param <E> Entity type
 * @param <I> Entity's identifier type
 * @param <F> Entity's dto type
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public interface IRestServiceCrudProcessor<E, I, F> extends IServiceCrudProcessor<E, I, F, Iterable<E>, Optional<E>> {

}
