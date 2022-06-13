package org.example.codefox.adapterpersistencereactivedataflux.spi;

import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;

/**
 * Interface {@code IJpaPersistPort} is a port interface used to provide
 * a first layer service to use abstraction of major jparepository operations
 *
 * @param <E> Concerns a type of entity
 * @param <I> Concerns an identifier Type of entity
 * @param <O> Concerns a single entity unit wrapped or not
 * @param <M> Concerns multiple entities wrapped onto container
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public interface IReactivePersistPort<E, I, M, O>
        extends IDefaultPersistPort<E, I, M, O> {

}
