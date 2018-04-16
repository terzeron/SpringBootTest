package net.terzeron.springboot;

import net.terzeron.springboot.api.facebook.Facebook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SocialConfig {
    @Bean
    @RequestScope
    public Facebook facebook(OAuth2AuthorizedClientService clientService) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accessToken = null;
        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientRgistrationId = oauthToken.getAuthorizedClientRegistrationId();
            if (clientRgistrationId.equals("facebook")) {
                OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRgistrationId, oauthToken.getName());
                accessToken = client.getAccessToken().getTokenValue();
            }
        }
        return new Facebook(accessToken);
    }
}
