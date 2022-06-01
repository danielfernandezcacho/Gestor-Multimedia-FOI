/**
 * Gestor-Multimedia-FOI - FOIGestorMultimedia.security - SecurityConfig
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 01/06/2022
 */
package FOIGestorMultimedia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import FOIGestorMultimedia.service.UsuarioServiceImpl;
/**
 * SecurityConfig.java
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioServiceImpl usuarioSerciveImpl;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioSerciveImpl);
	}
	
}
