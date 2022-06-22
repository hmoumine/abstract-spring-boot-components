package org.example.codefox.namebasicsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class {@code NameBasicsAppApplication} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "org.springframework.boot.context"})
public class NameBasicsAppApplication {

    public static void main(final String[] args) {
        SpringApplication.run(NameBasicsAppApplication.class, args);
    }
}
