package org.example.codefox.spicontrolleradapter.spi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Interface {@code IDefaultControllerPort} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 *
 * @param <F> Entity type
 * @param <I> Entity identifier type
 * @param <M> Multiple entity container type
 * @param <O> Single entity container
 */
public interface IDefaultControllerPort<F, I, M, O> {

    /**
     * Creates a new entity and returns created row as entity
     *
     * @param e Entity to save
     * @return Created Entity
     */
    @PostMapping(path = {"/public", ""}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    O create(@RequestBody final F e);

    /**
     * Creates a List of entities and returns an iterables of
     * created rows as iterable
     *
     * @param e Iterable of entities to save
     * @return Iterable of created entities
     */
    @PostMapping(path = {"/public/all", "/all"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    M createAll(@RequestBody final Iterable<F> e);

    /**
     * Updates an existing entity
     * Triggers an exception when the associated
     * id is absent from database
     *
     * @param e  Entity to update
     * @param id Associated identifier of entity
     * @return Updated entity
     */
    @PutMapping(path = {"/public/{id}", "/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    O update(@RequestBody F e, @PathVariable I id);

    /**
     * Retrieves an entity by identifier from database as optional entity
     *
     * @param id Identifier of entity
     * @return Identified entity as optional
     */
    @GetMapping(path = {"/public/{id}", "/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    O getById(@PathVariable("id") I id);

    /**
     * Retrieves all entities on database as iterable
     *
     * @return Iterable of all entities
     */
    @GetMapping(path = {"/public", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    M getAll();

    /**
     * Deletes an entity by identifier
     *
     * @param id Identifier of entity
     */
    @DeleteMapping(path = {"/public/{id}", "/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(@PathVariable("id") I id);

    /**
     * Hard Delete of entity by comparing object values from associated entity object
     *
     * @param e Entity object to remove
     */
    @DeleteMapping(path = {"/public/hard/{id}", "/hard/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void delete(@RequestBody F e, @PathVariable("id") I id);
}
