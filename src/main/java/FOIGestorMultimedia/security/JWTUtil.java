/**
 * Gestor-Multimedia-FOI - FOIGestorMultimedia.security - JWTUtil
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 01/06/2022
 */
package FOIGestorMultimedia.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWTUtil.java
 *
 */
public class JWTUtil {
	
	private static final String KEY = "foigestor";//System.getenv("KEY")

	public String generateToken(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
		
	}
	
}
