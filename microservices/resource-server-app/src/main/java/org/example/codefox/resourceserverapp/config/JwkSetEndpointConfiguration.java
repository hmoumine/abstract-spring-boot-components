package org.example.codefox.resourceserverapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * Class {@code JwkSetEndpointConfiguration} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@Configuration
public class JwkSetEndpointConfiguration {

    @Value("${server.context.key-path:/.well-known/jwks.json}")
    private String keyPath;

    @Bean
    public ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry configure(final HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .requestMatchers()
                .mvcMatchers(keyPath)
                .and()
                .authorizeRequests()
                .mvcMatchers(keyPath)
                .permitAll();

    }
}
