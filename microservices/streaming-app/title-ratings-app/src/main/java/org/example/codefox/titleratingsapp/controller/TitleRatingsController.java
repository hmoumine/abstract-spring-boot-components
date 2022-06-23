package org.example.codefox.titleratingsapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domaintitleratings.model.TitleRatings;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code TitleRatingsController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class TitleRatingsController extends DefaultReactorControllerAdapter<TitleRatings, UUID, TitleRatings> {

    public TitleRatingsController(final IDefaultCrudServicePort<TitleRatings, UUID, TitleRatings, Flux<TitleRatings>, Mono<TitleRatings>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }

}
