package org.example.codefox.crudrestserviceadapter.spi;

import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;

/**
 * Interface {@code ICrudServicePort} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

/**
 *
 * @param <E> Entity type
 * @param <I> Entity's identifier type
 * @param <F> Entity's dto type
 * @param <M> Multiple entities container type
 * @param <O> Single entity container type
 */
public interface IRestServiceCrudProcessor<E, I, F, M, O> extends IServiceCrudProcessor<E, I, F, M, O> {


}
