package org.example.codefox.spiserviceadapter.functional;

/**
 * Interface {@code IBiArgFunctionalInterface} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

@FunctionalInterface
public interface IBiArgFunctionalInterface<E, F> {

    F apply(E src, F dest);
}
