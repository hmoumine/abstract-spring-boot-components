package org.example.codefox.restcontrolleradapter.adapter;

import org.example.codefox.spicontrolleradapter.spi.IDefaultControllerPort;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Class {@code DefaultRestControllerAdapter} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
//FIXME Check Mapping /[a-z] for child
public class DefaultRestControllerAdapter<F, ID, E> implements IDefaultControllerPort<F, ID, Iterable<E>, E> {

    private final IDefaultCrudServicePort<E, ID, F, Iterable<E>, E> iDefaultCrudServicePort;

    @Autowired
    public DefaultRestControllerAdapter(final IDefaultCrudServicePort<E, ID, F, Iterable<E>, E> iDefaultCrudServicePort) {
        this.iDefaultCrudServicePort = iDefaultCrudServicePort;
    }

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public E create(final F e) {
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
    public Iterable<E> createAll(final Iterable<F> e) {
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
    public E update(final F e, final ID id) {
        return this.iDefaultCrudServicePort.update(e, id);
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public E getById(final ID id) {
        return this.iDefaultCrudServicePort.getById(id);
    }

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @Override
    public Iterable<E> getAll() {
        return this.iDefaultCrudServicePort.getAll();
    }

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @Override
    public void deleteById(final ID id) {
        this.iDefaultCrudServicePort.deleteById(id);
    }

    /**
     * Hard Delete of entity by comparing object values from associated entity object
     *
     * @param e  Entity object to remove
     * @param id Entity identifier type
     */
    @Override
    public void delete(final F e, final ID id) {
        this.iDefaultCrudServicePort.delete(e, id);
    }
}
