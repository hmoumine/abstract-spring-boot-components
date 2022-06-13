package org.example.codefox.domaincommons.spi;

/**
 * The interface Model port.
 *
 * @param <E> the type parameter
 * @param <I> the type parameter
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
public interface IModelPort<E, I> {

    /**
     * Create.
     *
     * @param e the e
     */
    void create(E e);

    /**
     * Update.
     *
     * @param e the e
     */
    void update(E e);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    E getById(I id);

    /**
     * Delete.
     *
     * @param e the e
     */
    void delete(E e);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(I id);
}
