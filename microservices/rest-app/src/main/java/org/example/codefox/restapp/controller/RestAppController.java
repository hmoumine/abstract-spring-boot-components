package org.example.codefox.restapp.controller;

import org.example.codefox.domainpole.entities.PoleEntity;
import org.example.codefox.domainpole.model.Pole;
import org.example.codefox.restcontrolleradapter.adapter.DefaultRestControllerAdapter;
import org.example.codefox.spiserviceadapter.spi.IDefaultCrudServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Class {@code RestAppController} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@RestController
@RequestMapping("/pole")
public class RestAppController extends DefaultRestControllerAdapter<Pole, UUID, PoleEntity> {

    @Autowired
    public RestAppController(final IDefaultCrudServicePort<PoleEntity, UUID, Pole, Iterable<PoleEntity>, PoleEntity> iDefaultCrudServicePort) {
        super(iDefaultCrudServicePort);
    }
    
}
