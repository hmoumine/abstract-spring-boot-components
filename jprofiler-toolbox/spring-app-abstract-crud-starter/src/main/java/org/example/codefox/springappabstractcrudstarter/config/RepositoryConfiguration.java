package org.example.codefox.springappabstractcrudstarter.config;

import org.example.codefox.springappcustomannotations.annotation.AbdEnableJpaRepositories;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class {@code RepositoryConfiguration} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
@AbdEnableJpaRepositories("${jpa.repository.packages}")
@EntityScan(basePackages = "${jpa.repository.ms.entity}")
@ConditionalOnProperty(value = {"jpa.repository.packages", "jpa.repository.ms.entity"})
public class RepositoryConfiguration {
}
