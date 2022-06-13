package org.example.codefox.crudreactiveserviceadapter.spi;

import org.example.codefox.spiserviceadapter.processing.IServiceCrudProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interface {@code ICrudServicePort} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */

public interface ICrudReactiveServiceCrudProcessor<E, I, F>
        extends IServiceCrudProcessor<E, I, F, Flux<E>, Mono<E>> {


}
