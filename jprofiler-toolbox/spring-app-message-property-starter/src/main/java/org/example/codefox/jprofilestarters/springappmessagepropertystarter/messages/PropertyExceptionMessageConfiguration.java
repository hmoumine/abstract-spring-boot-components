package org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * The class Property exception message configuration.
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
@Getter
@Configuration
@ConfigurationProperties(prefix = "app.messages.exception")
public class PropertyExceptionMessageConfiguration {

    private String entityIdNotFoundException = ENTITY_ID_NOT_FOUND;

    private String entitySaveException = ENTITY_SAVING_EXCEPTION;

    private String entityMappingException = ENTITY_MAPPING_EXCEPTION;

}
