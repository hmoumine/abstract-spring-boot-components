package org.example.codefox.spipersistenceport.spi;

/**
 * Interface {@code IDefaultPersistPort} is a port interface used to provide
 * a first layer service to use abstraction of major database operations
 *
 * @param <E>  Concerned type of entity
 * @param <I> Concerned identifier Type of entity
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public interface IDefaultPersistPort<E, I, M, O> {

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    O create(E e);

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param eIterable Iterable of entities to save
     * @return Iterable of created entities
     */
    M createAll(Iterable<E> eIterable);

    /**
     * Updates an existing entity
     * Triggers an exception when the associated
     * id is absent from database
     *
     * @param e  Entity to update
     * @return Updated entity
     */
    O update(E e);

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    O getById(I id);

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    M getAll();

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    void deleteById(I id);

    /**
     * Deletes an entity by associated entity object
     *
     * @param e Entity object to remove
     */
    void delete(E e);
}
