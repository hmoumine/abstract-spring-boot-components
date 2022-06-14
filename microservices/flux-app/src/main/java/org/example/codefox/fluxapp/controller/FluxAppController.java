package org.example.codefox.fluxapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domainpolereactive.entities.PoleEntity;
import org.example.codefox.domainpolereactive.model.Pole;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code FluxAppController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
@RequestMapping("/flux/pole")
public class FluxAppController extends DefaultReactorControllerAdapter<Pole, UUID, PoleEntity> {
    public FluxAppController(final IDefaultCrudServicePort<PoleEntity, UUID, Pole, Flux<PoleEntity>, Mono<PoleEntity>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }
}
