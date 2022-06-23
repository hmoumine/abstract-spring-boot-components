package org.example.codefox.titlebasicsapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domaintitlebasics.model.TitleBasics;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code TitleBasicsController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class TitleBasicsController extends DefaultReactorControllerAdapter<TitleBasics, UUID, TitleBasics> {

    public TitleBasicsController(final IDefaultCrudServicePort<TitleBasics, UUID, TitleBasics, Flux<TitleBasics>, Mono<TitleBasics>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }

}
