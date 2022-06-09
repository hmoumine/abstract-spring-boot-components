package org.example.codefox.crudrestserviceadapter.processing;

import jakarta.persistence.EntityNotFoundException;
import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;
import org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.example.codefox.toolboxconstants.exceptions.EntitySaveException;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.crudrestserviceadapter.spi.IRestServiceCrudProcessor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Class {@code ACrudServiceAdapter} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Service
public class DefaultServiceRestProcessor<E, I, F>
        implements IRestServiceCrudProcessor<E, I, F, Iterable<E>, Optional<E>> {

    private final IDefaultPersistPort<E, I, Iterable<E>, Optional<E>> iDefaultPersistPort;

    private final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration;

    public DefaultServiceRestProcessor(
            final IDefaultPersistPort<E, I, Iterable<E>, Optional<E>> defaultPersistPort,
            final PropertyExceptionMessageConfiguration propertyExceptionMessageConfiguration
    ) {
        this.iDefaultPersistPort = defaultPersistPort;
        this.propertyExceptionMessageConfiguration = propertyExceptionMessageConfiguration;
    }
    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public Optional<E> create(final F e, final ISingleArgFunctionalInterface<F, Optional<E>> functionalMapper) {
        return Optional.of(e)
                .flatMap(functionalMapper)
                .flatMap(this.iDefaultPersistPort::create)
                .or(() -> {
                    throw new EntitySaveException(
                            propertyExceptionMessageConfiguration.getEntitySaveException());
                });
    }

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param eIterable Iterable of entities to save
     * @return Iterable of created entities
     */
    @Override
    public Iterable<E> createAll(final Iterable<F> eIterable, final ISingleArgFunctionalInterface<F, Stream<E>> functionalMapper) {
        final Set<E> mappedDtos = StreamSupport.stream(eIterable.spliterator(), true)
                     .flatMap(functionalMapper)
                     .collect(Collectors.toSet());
        return iDefaultPersistPort.createAll(mappedDtos);
    }

    /**
     * Updates an existing entity
     * Triggers an exception when the associated
     * id is absent from database
     *
     * @param e Entity to update
     * @return Updated entity
     */
    @Override
    public Optional<E> update(final F e, final I id, final IBiArgFunctionalInterface<F, Optional<E>> functionalMapper) {
        return this.iDefaultPersistPort.getById(id)
                .flatMap(elt -> functionalMapper.apply(e, Optional.of(elt)))
                .flatMap(this.iDefaultPersistPort::update)
                .or(() -> {
                    throw new EntityNotFoundException(
                            propertyExceptionMessageConfiguration.getEntityIdNotFoundException());
                });
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public Optional<E> getById(final I id) {
        return this.iDefaultPersistPort.getById(id);
    }

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @Override
    public Iterable<E> getAll() {
        return this.iDefaultPersistPort.getAll();
    }

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @Override
    public void deleteById(final I id) {
        this.iDefaultPersistPort.getById(id)
                .ifPresentOrElse(
                        this.iDefaultPersistPort::delete,
                        () -> new EntityNotFoundException(
                                propertyExceptionMessageConfiguration.getEntityIdNotFoundException()));
    }

    /**
     * Deletes an entity by associated entity object
     *
     * @param e  Entity object to remove
     * @param id Entity type identifier
     */
    @Override
    public void delete(final F e, final I id) {
        this.iDefaultPersistPort.getById(id)
                .ifPresentOrElse(
                        this.iDefaultPersistPort::delete,
                        () -> new EntityNotFoundException(
                                propertyExceptionMessageConfiguration.getEntityIdNotFoundException()));
    }

}
