package org.example.codefox.apiserviceadapter.spi;

/**
 * Interface {@code IDefaultCrudServicePort} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

public interface IDefaultCrudServicePort<E, ID, F, MULTI, MONO> {

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    MONO create(final F e);

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param e Iterable of entities to save
     * @return Iterable of created entities
     */
    MULTI createAll(final Iterable<F> e);

    /**
     * Updates an existing entity
     * Triggers an exception when the associated
     * id is absent from database
     *
     * @param e  Entity to update
     * @param id Associated identifier of entity
     * @return Updated entity
     */
    MONO update(F e, ID id);

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    MONO getById(ID id);

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    MULTI getAll();

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    void deleteById(ID id);

    /**
     * Deletes an entity by associated entity object
     *
     * @param e Entity object to remove
     */
    void delete(F e, ID id);
}