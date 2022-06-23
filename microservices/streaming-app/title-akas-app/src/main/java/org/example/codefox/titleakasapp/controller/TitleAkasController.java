package org.example.codefox.titleakasapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domaintitleakas.model.AlsoKnownAs;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code TitleAkasController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class TitleAkasController extends DefaultReactorControllerAdapter<AlsoKnownAs, UUID, AlsoKnownAs> {

    public TitleAkasController(final IDefaultCrudServicePort<AlsoKnownAs, UUID, AlsoKnownAs, Flux<AlsoKnownAs>, Mono<AlsoKnownAs>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }

}
