package org.example.codefox.namebasicsapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domainnamebasics.model.NameBasics;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Class {@code NameBasicsController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class NameBasicsController extends DefaultReactorControllerAdapter<NameBasics, String, NameBasics> {
    public NameBasicsController(final IDefaultCrudServicePort<NameBasics, String, NameBasics, Flux<NameBasics>, Mono<NameBasics>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }
}
