package org.example.jprofiler.infrastructure.adapterpersistencedatajpa.spi;

import org.example.codefox.jprofiler.components.infrastructure.spiport.spi.IDefaultPersistPort;

/**
 * Interface {@code IJpaPersistPort} is a port interface used to provide
 * a first layer service to use abstraction of major jparepository operations
 *
 * @param <E>  Concerned type of entity
 * @param <ID> Concerned identifier Type of entity
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public interface IJpaPersistPort<E, ID, MULTI, Optional>
        extends IDefaultPersistPort<E, ID, MULTI, Optional> {

}
