package org.example.codefox.crudrestserviceadapter.adapter;

import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;

import java.util.Optional;
import java.util.stream.Stream;


public class CrudRestServiceAdapter<E, I, F> implements IDefaultCrudServicePort<E, I, F, Iterable<E>, Optional<E>> {

    private final IServiceCrudProcessor<E, I, F, Iterable<E>, Optional<E>> iServiceCrudProcessor;

    private final ISingleArgFunctionalInterface<F, Optional<E>> dtoToOptionalEntityFunc;

    private final ISingleArgFunctionalInterface<F, Stream<E>> dtoToStreamEntityFunc;

    private final IBiArgFunctionalInterface<F, Optional<E>> entityToEntityFunc;

    public CrudRestServiceAdapter(
            final IServiceCrudProcessor<E, I, F, Iterable<E>, Optional<E>> iServiceCrudProcessor,
            final ISingleArgFunctionalInterface<F, Optional<E>> dtoToOptionalEntityFunc,
            final ISingleArgFunctionalInterface<F, Stream<E>> dtoToStreamEntityFunc,
            final IBiArgFunctionalInterface<F, Optional<E>> entityToEntityFunc) {
        this.iServiceCrudProcessor = iServiceCrudProcessor;
        this.dtoToOptionalEntityFunc = dtoToOptionalEntityFunc;
        this.dtoToStreamEntityFunc = dtoToStreamEntityFunc;
        this.entityToEntityFunc = entityToEntityFunc;
    }

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public Optional<E> create(final F e) {
        return this.iServiceCrudProcessor.create(e, this.dtoToOptionalEntityFunc);
    }

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param e Iterable of entities to save
     * @return Iterable of created entities
     */
    @Override
    public Iterable<E> createAll(final Iterable<F> e) {
        return this.iServiceCrudProcessor.createAll(e, this.dtoToStreamEntityFunc);
    }

    /**
     * Updates an existing entity
     * Triggers an exception when the associated
     * id is absent from database
     *
     * @param e  Entity to update
     * @param id Associated identifier of entity
     * @return Updated entity
     */
    @Override
    public Optional<E> update(final F e, final I id) {
        return this.iServiceCrudProcessor.update(e, id, this.entityToEntityFunc);
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public Optional<E> getById(final I id) {
        return this.iServiceCrudProcessor.getById(id);
    }

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @Override
    public Iterable<E> getAll() {
        return this.iServiceCrudProcessor.getAll();
    }

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @Override
    public void deleteById(final I id) {
        this.iServiceCrudProcessor.deleteById(id);
    }

    /**
     * Deletes an entity by associated entity object
     *
     * @param e  Entity object to remove
     * @param id Entity type identifier
     */
    @Override
    public void delete(final F e, final I id) {
        this.iServiceCrudProcessor.delete(e, id);
    }
}
