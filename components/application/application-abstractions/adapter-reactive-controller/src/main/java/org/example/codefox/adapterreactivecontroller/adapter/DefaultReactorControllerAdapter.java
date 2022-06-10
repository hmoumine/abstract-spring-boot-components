package org.example.codefox.adapterreactivecontroller.adapter;

import org.example.codefox.spicontrolleradapter.spi.IDefaultControllerPort;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class {@code DefaultReactorControllerAdapter} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
public class DefaultReactorControllerAdapter<F, I, E> implements IDefaultControllerPort<F, I, Flux<E>, Mono<E>> {

    private final IDefaultCrudServicePort<E, I, F, Flux<E>, Mono<E>> iDefaultCrudServicePort;

    public DefaultReactorControllerAdapter(final IDefaultCrudServicePort<E, I, F, Flux<E>, Mono<E>> iDefaultCrudServicePort) {
        this.iDefaultCrudServicePort = iDefaultCrudServicePort;
    }

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public Mono<E> create(final F e) {
        return this.iDefaultCrudServicePort.create(e);
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
        return this.iDefaultCrudServicePort.createAll(e);
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
    public Mono<E> update(final F e, final I id) {
        return this.iDefaultCrudServicePort.update(e, id);
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public Mono<E> getById(final I id) {
        return this.iDefaultCrudServicePort.getById(id);
    }

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @Override
    public Flux<E> getAll() {
        return this.iDefaultCrudServicePort.getAll();
    }

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @Override
    public void deleteById(final I id) {
        this.iDefaultCrudServicePort.deleteById(id);
    }

    /**
     * Hard Delete of entity by comparing object values from associated entity object
     *
     * @param e  Entity object to remove
     * @param id
     */
    @Override
    public void delete(final F e, final I id) {
        this.iDefaultCrudServicePort.delete(e, id);
    }
}
