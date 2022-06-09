package org.example.codefox.resourceserverapp.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * Class {@code JwtKeySetEndpoint} provides [...]
 *
 * @author Hamza MOUMINE
 * @see <a href="h.moumine@outlook.com">h.moumine@outlook.com</a>
 * @see <a href="https://www.linkedin.com/in/hamza-moumine">LinkedIn Profile</a>
 * @see <a href="https://consort-group.com/">Employed by Consort NT Group</a>
 */
@FrameworkEndpoint
class JwtKeySetEndpoint {
    private final KeyPair keyPair;

    public JwtKeySetEndpoint(final KeyPair keyPair) {
        this.keyPair = keyPair;
    }

    @ResponseBody
    @GetMapping("${server.context.key-path:/.well-known/jwks.json}")
    public Map<String, Object> getKey() {
        final RSAPublicKey publicKey = (RSAPublicKey) this.keyPair.getPublic();
        final RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }
}