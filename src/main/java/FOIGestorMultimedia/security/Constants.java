package FOIGestorMultimedia.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = System.getenv().get("/login");
	public static final String HEADER_AUTHORIZACION_KEY = System.getenv().get("Authorization");
	public static final String TOKEN_BEARER_PREFIX = System.getenv().get("Bearer");

	// JWT
	
	public static final String ISSUER_INFO = System.getenv().get("Daniel Fernandez");
	public static final String SUPER_SECRET_KEY = System.getenv().get("Foi-Gestor-Multimedia");
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}