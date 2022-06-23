package org.example.codefox.titleprincipalsapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domaintitleprincipals.model.TitlePrincipals;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code TitlePrincipalsController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class TitlePrincipalsController extends DefaultReactorControllerAdapter<TitlePrincipals, UUID, TitlePrincipals> {

    public TitlePrincipalsController(final IDefaultCrudServicePort<TitlePrincipals, UUID, TitlePrincipals, Flux<TitlePrincipals>, Mono<TitlePrincipals>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }

}
