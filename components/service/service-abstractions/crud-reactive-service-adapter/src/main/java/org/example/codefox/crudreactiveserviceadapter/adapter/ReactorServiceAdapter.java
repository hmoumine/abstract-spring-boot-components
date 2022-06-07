package org.example.codefox.crudreactiveserviceadapter.adapter;

import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.crudreactiveserviceadapter.spi.ICrudReactiveServiceCrudProcessor;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

/**
 * Class {@code ReactorServiceAdapter} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Service
public class ReactorServiceAdapter<E, ID, F> implements IDefaultCrudServicePort<E, ID, F, Flux<E>, Mono<E>> {

    private final ICrudReactiveServiceCrudProcessor<E, ID, F, Flux<E>, Mono<E>> iCrudReactiveServiceCrudProcessor;

    private final ISingleArgFunctionalInterface<F, Mono<E>> dtoToMonoEntityFunc;

    private final ISingleArgFunctionalInterface<F, Stream<E>> dtoToFluxEntityFunc;

    private final IBiArgFunctionalInterface<F, Mono<E>> entityToMonoEntityFunc;

    public ReactorServiceAdapter(final ICrudReactiveServiceCrudProcessor<E, ID, F, Flux<E>, Mono<E>> iCrudReactiveServiceCrudProcessor,
                                 final ISingleArgFunctionalInterface<F, Mono<E>> dtoToMonoEntityFunc,
                                 final ISingleArgFunctionalInterface<F, Stream<E>> dtoToFluxEntityFunc,
                                 final IBiArgFunctionalInterface<F, Mono<E>> entityToMonoEntityFunc) {
        this.iCrudReactiveServiceCrudProcessor = iCrudReactiveServiceCrudProcessor;
        this.dtoToFluxEntityFunc = dtoToFluxEntityFunc;
        this.dtoToMonoEntityFunc = dtoToMonoEntityFunc;
        this.entityToMonoEntityFunc = entityToMonoEntityFunc;
    }

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public Mono<E> create(final F e) {
        return this.iCrudReactiveServiceCrudProcessor.create(e, this.dtoToMonoEntityFunc);
    }

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param e Iterable of entities to save
     * @return Iterable of created entities
     */
    @Override
    public Flux<E> createAll(final Iterable<F> e) {
        return this.iCrudReactiveServiceCrudProcessor.createAll(e, this.dtoToFluxEntityFunc);
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
    public Mono<E> update(final F e, final ID id) {
        return this.iCrudReactiveServiceCrudProcessor.update(e, id, this.entityToMonoEntityFunc);
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public Mono<E> getById(final ID id) {
        return this.iCrudReactiveServiceCrudProcessor.getById(id);
    }

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @Override
    public Flux<E> getAll() {
        return this.iCrudReactiveServiceCrudProcessor.getAll();
    }

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @Override
    public void deleteById(final ID id) {
        this.iCrudReactiveServiceCrudProcessor.deleteById(id);
    }

    /**
     * Deletes an entity by associated entity object
     *
     * @param e  Entity object to remove
     * @param id Entity identifier type
     */
    @Override
    public void delete(final F e, final ID id) {
        this.iCrudReactiveServiceCrudProcessor.delete(e, id);
    }
}
