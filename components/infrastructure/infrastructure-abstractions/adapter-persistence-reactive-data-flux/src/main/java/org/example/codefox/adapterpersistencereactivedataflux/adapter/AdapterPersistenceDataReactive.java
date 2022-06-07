package org.example.codefox.adapterpersistencereactivedataflux.adapter;

import org.example.codefox.spipersistenceport.spi.IDefaultPersistPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * {@inheritDoc}
 */
public class AdapterPersistenceDataReactive<E, ID>
        implements IDefaultPersistPort<E, ID, Flux<E>, Mono<E>> {

    /**
     * Reactive Crud repository
     */
    private ReactiveCrudRepository<E, ID> repository;

    /**
     * Instantiates a new Adapter persistence data jpa.
     *
     * @param repository the repository
     */
    @Autowired
    public AdapterPersistenceDataReactive(
            final ReactiveCrudRepository<E, ID> repository
    ) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<E> create(E e) {
        return this.repository.save(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<E> createAll(Iterable<E> eIterable) {
        return this.repository.saveAll(eIterable);
    }

    /**
     * Update e.
     *
     * @param e the e
     * @return the e
     */
    @Override
    public Mono<E> update(E e) {
        return this.repository.save(e);
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Override
    public Mono<E> getById(ID id) {
        return this.repository.findById(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @Override
    public Flux<E> getAll() {
        return this.repository.findAll();
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }

    /**
     * Delete.
     *
     * @param e the e
     */
    @Override
    public void delete(E e) {
        this.repository.delete(e);
    }
}
