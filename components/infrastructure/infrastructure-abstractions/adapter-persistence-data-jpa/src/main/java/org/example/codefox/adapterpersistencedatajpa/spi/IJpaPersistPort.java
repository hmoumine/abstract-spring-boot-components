package org.example.codefox.adapterpersistencedatajpa.spi;

import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;

/**
 * Interface {@code IJpaPersistPort} is a port interface used to provide
 * a first layer service to use abstraction of major jparepository operations
 *
 * @param <E>  Concerned type of entity
 * @param <I> Concerned identifier Type of entity
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

/**
 *
 * @param <E> Entity type
 * @param <I> Entity identifier type
 * @param <M> Multiple entities container type
 * @param <O> Single entity container type
 */
public interface IJpaPersistPort<E, I, M, O>
        extends IDefaultPersistPort<E, I, M, O> {

}
