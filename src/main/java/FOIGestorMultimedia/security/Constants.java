package FOIGestorMultimedia.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = System.getenv().get("LOGIN_URL");
	public static final String HEADER_AUTHORIZACION_KEY = System.getenv().get("HEADER_AUTHORIZACION_KEY");
	public static final String TOKEN_BEARER_PREFIX = System.getenv().get("TOKEN_BEARER_PREFIX");

	// JWT
	
	public static final String ISSUER_INFO = System.getenv().get("ISSUER_INFO");
	public static final String SUPER_SECRET_KEY = System.getenv().get("SUPER_SECRET_KEY");
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}