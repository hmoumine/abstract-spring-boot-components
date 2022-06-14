package org.example.codefox.crudreactiveserviceadapter.processing;

import lombok.AllArgsConstructor;
import org.example.codefox.crudreactiveserviceadapter.spi.ICrudReactiveServiceCrudProcessor;
import org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages.PropertyExceptionMessageConfiguration;
import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;
import org.example.codefox.spiserviceadapter.functional.IBiArgFunctionalInterface;
import org.example.codefox.spiserviceadapter.functional.ISingleArgFunctionalInterface;
import org.example.codefox.toolboxconstants.exceptions.EntityMappingException;
import org.example.codefox.toolboxconstants.exceptions.EntityNotFoundException;
import org.example.codefox.toolboxconstants.exceptions.EntitySaveException;
import org.springframework.stereotype.Service;
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

@Service
@AllArgsConstructor
public class DefaultServiceReactorProcessor<E, I, F>
        implements ICrudReactiveServiceCrudProcessor<E, I, F> {

    private IDefaultPersistPort<E, I, Flux<E>, Mono<E>> iDefaultPersistPort;

    private PropertyExceptionMessageConfiguration pemc;

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @Override
    public Mono<E> create(final F e, final ISingleArgFunctionalInterface<F, Mono<E>> functionalMapper) {
        return functionalMapper.apply(e)
                .onErrorResume(throwable -> Mono.error(
                        new EntityMappingException(pemc.entityMappingException, throwable)))
                .flatMap(elt -> this.iDefaultPersistPort.create(elt))
                .onErrorResume(throwable -> Mono.error(
                        new EntitySaveException(pemc.entitySaveException, throwable)));
    }

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param eIterable Iterable of entities to save
     * @return Iterable of created entities
     */
    @Override
    public Flux<E> createAll(final Iterable<F> eIterable, final ISingleArgFunctionalInterface<F, Stream<E>> functionalMapper) {
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
    public Mono<E> update(final F e, final I id, final IBiArgFunctionalInterface<F, Mono<E>> functionalMapper) {
        return this.iDefaultPersistPort.getById(id)
                .flatMap(elt -> functionalMapper.apply(e, Mono.just(elt)))
                .onErrorResume(throwable -> Mono.error(
                        new EntityMappingException(pemc.entityMappingException, throwable)))
                .flatMap(flatted -> this.iDefaultPersistPort.update(flatted))
                .onErrorResume(throwable -> Mono.error(
                        new EntityNotFoundException(pemc.entityIdNotFoundException, throwable)));
    }

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @Override
    public Mono<E> getById(final I id) {
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
    public void deleteById(final I id) {
        this.iDefaultPersistPort.getById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(pemc.entityIdNotFoundException)))
                .doOnNext(elt -> this.iDefaultPersistPort.delete(elt));
    }

    /**
     * Deletes an entity by associated entity object
     *
     * @param e  Entity object to remove
     * @param id
     */
    @Override
    public void delete(F e, I id) {
        System.err.println("Undefined function delete.\nAt DefaultServiceReactorProcessor line 131");
    }

}
