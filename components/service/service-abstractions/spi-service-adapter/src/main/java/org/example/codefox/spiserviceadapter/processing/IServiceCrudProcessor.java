package org.example.codefox.spiserviceadapter.processing;

import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;

import java.util.stream.Stream;


public interface IServiceCrudProcessor<E, I, F, M, O> {

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    O create(final F e, final ISingleArgFunctionalInterface<F, O> functionalMapper);

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param e Iterable of entities to save
     * @return Iterable of created entities
     */
    M createAll(final Iterable<F> e, final ISingleArgFunctionalInterface<F, Stream<E>> functionalMapper);

    /**
     * Updates an existing entity
     * Triggers an exception when the associated
     * id is absent from database
     *
     * @param e  Entity to update
     * @param id Associated identifier of entity
     * @return Updated entity
     */
    O update(F e, I id, final IBiArgFunctionalInterface<F, O> functionalMapper);

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
    void delete(F e, I id);
}
