package io.javabrains.betterreads;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	/**
	 * Spring Security configuration that sets up OAuth login and enables all URLs
	 * to be accessible without authentication. Also sets up CSRF protection.
	 */
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(a -> a
				.anyRequest().permitAll()
			)
			.exceptionHandling(e -> e
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
			)
			// Disabling security
			//.csrf().disable()
			.csrf(c -> c
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			)
			.logout(l -> l
			    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))            
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")     
				.logoutSuccessUrl("/")
				.permitAll()
			)
			.oauth2Login();
    }
    
    /**
     * Look for user in the principal.
     * 
     * @param principal
     *      current securty context
     * @return
     *      user id
     */
    public static String getUserId(OAuth2User principal ) {
        String userId = null;
        if (principal != null) {
            if (principal.getAttribute("login") != null) {
                userId = principal.getAttribute("login");
            } else if (principal.getAttribute("email") != null) {
                userId = principal.getAttribute("email");
            }
        }
        return userId;
    }
    
}
