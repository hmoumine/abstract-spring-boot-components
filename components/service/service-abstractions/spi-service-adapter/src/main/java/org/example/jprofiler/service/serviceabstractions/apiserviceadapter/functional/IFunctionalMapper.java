package org.example.jprofiler.service.serviceabstractions.apiserviceadapter.functional;

import java.util.function.Function;

/**
 * Interface {@code IErazurFunctionalMapping} provides [...]
 * Provides mapping function to accomplish data injection
 * between two given types
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public interface IFunctionalMapper<E, F> extends Function<E, F> {

    /**
     * Copy values from source to target
     *
     * @param source Source object
     * @return Updated object
     */
    F map(final E source);

}
