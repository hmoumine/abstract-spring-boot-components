package org.example.jprofiler.service.serviceabstractions.crudreactiveserviceadapter.adapter;

import org.example.codefox.jprofiler.components.infrastructure.spiport.spi.IDefaultPersistPort;
import org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.example.jprofiler.jprofilertoolbox.constants.exceptions.EntityMappingException;
import org.example.jprofiler.jprofilertoolbox.constants.exceptions.EntityNotFoundException;
import org.example.jprofiler.jprofilertoolbox.constants.exceptions.EntitySaveException;
import org.example.jprofiler.service.serviceabstractions.apiserviceadapter.functional.IFunctionalMapper;
import org.example.jprofiler.service.serviceabstractions.crudreactiveserviceadapter.spi.ICrudReactiveServicePort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
public abstract class ACrudReactiveServiceAdapter<E, ID, F>
        implements ICrudReactiveServicePort<E, ID, F, Flux<E>, Mono<E>> {

    private IDefaultPersistPort<E, ID, Flux<E>, Mono<E>> iDefaultPersistPort;

    private PropertyExceptionMessageConfiguration pemc;

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public Mono<E> create(final F e, final IFunctionalMapper<F, Mono<E>> functionalMapper) {
        return functionalMapper.map(e)
                .onErrorResume(throwable -> Mono.error(
                        new EntityMappingException(pemc.getEntityMappingException(), throwable)))
                .flatMap(elt -> this.iDefaultPersistPort.create(elt))
                .onErrorResume(throwable -> Mono.error(
                        new EntitySaveException(pemc.getEntitySaveException(), throwable)));
    }

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param eIterable Iterable of entities to save
     * @return Iterable of created entities
     */
    @Override
    public Flux<E> createAll(final Iterable<F> eIterable, final IFunctionalMapper<F, Stream<E>> functionalMapper) {
        Set<E> mappedDtos = StreamSupport.stream(eIterable.spliterator(), true)
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
    public Mono<E> update(final F e, final ID id, final IFunctionalMapper<E, Mono<E>> functionalMapper) {
        return this.iDefaultPersistPort.getById(id)
                .flatMap(functionalMapper)
                .onErrorResume(throwable -> Mono.error(
                        new EntityMappingException(pemc.getEntityMappingException(), throwable)))
                .flatMap(flatted -> this.iDefaultPersistPort.update(flatted))
                .onErrorResume(throwable -> Mono.error(
                        new EntityNotFoundException(pemc.getEntityIdNotFoundException(), throwable)));
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public Mono<E> getById(final ID id) {
        return this.iDefaultPersistPort.getById(id);
    }

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @Override
    public Flux<E> getAll() {
        return this.iDefaultPersistPort.getAll();
    }

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @Override
    public void deleteById(final ID id) {
        this.iDefaultPersistPort.getById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(pemc.getEntityIdNotFoundException())))
                .doOnNext(elt -> this.iDefaultPersistPort.delete(elt));
    }

}
