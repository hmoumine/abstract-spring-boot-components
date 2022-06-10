package org.example.codefox.adapterpersistencedatajpa.adapter;

import org.example.codefox.adapterpersistencedatajpa.spi.IJpaPersistPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * {@inheritDoc}
 */
public class AdapterPersistenceDataJpa<E, I>
        implements IJpaPersistPort<E, I, Iterable<E>, Optional<E>> {

    private final JpaRepository<E, I> repository;

    /**
     * Instantiates a new Adapter persistence data jpa.
     *
     * @param repository                            the repository
     */
    public AdapterPersistenceDataJpa(final JpaRepository<E, I> repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<E> create(final E e) {
        return Optional.of(this.repository.save(e));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterable<E> createAll(final Iterable<E> eIterable) {
        return this.repository.saveAll(eIterable);
    }

    /**
     * Update e.
     *
     * @param e the e
     * @return the e
     */
    @Override
    public Optional<E> update(final E e) {
        return Optional.of(this.repository.save(e));
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Override
    public Optional<E> getById(final I id) {
        return this.repository.findById(id);
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @Override
    public Iterable<E> getAll() {
        return this.repository.findAll();
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(final I id) {
        this.repository.deleteById(id);
    }

    /**
     * Delete.
     *
     * @param e the e
     */
    @Override
    public void delete(final E e) {
        this.repository.delete(e);
    }
}
