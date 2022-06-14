package org.example.codefox.jprofilestarters.springappmessagepropertystarter.messages;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static org.example.codefox.toolboxconstants.messages.RepositoryExceptionConstants.*;

/**
 * The class Property exception message configuration.
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine?originalSubdomain=fr">LinkedIn Profile</a>
 */
@Configuration
@ConfigurationProperties(prefix = "app.messages.exception")
public class PropertyExceptionMessageConfiguration {

    public String entityIdNotFoundException = ENTITY_ID_NOT_FOUND;

    public String entitySaveException = ENTITY_SAVING_EXCEPTION;

    public String entityMappingException = ENTITY_MAPPING_EXCEPTION;

}
