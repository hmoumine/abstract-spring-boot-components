package org.example.codefox.titleepisodeapp.controller;

import org.example.codefox.adapterreactivecontroller.adapter.DefaultReactorControllerAdapter;
import org.example.codefox.domaintitleepisode.model.TitleEpisode;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Class {@code TitleEpisodeController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
public class TitleEpisodeController extends DefaultReactorControllerAdapter<TitleEpisode, UUID, TitleEpisode> {

    public TitleEpisodeController(final IDefaultCrudServicePort<TitleEpisode, UUID, TitleEpisode, Flux<TitleEpisode>, Mono<TitleEpisode>> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }

}
