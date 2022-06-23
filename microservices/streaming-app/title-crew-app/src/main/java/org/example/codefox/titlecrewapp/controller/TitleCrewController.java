package org.example.codefox.titlecrewapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domaintitlecrew.model.TitleCrew;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code TitleCrewController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class TitleCrewController extends DefaultReactorControllerAdapter<TitleCrew, UUID, TitleCrew> {

    public TitleCrewController(final IDefaultCrudServicePort<TitleCrew, UUID, TitleCrew, Flux<TitleCrew>, Mono<TitleCrew>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }

}
