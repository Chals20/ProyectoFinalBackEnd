package com.pacoteck.springboot.app.security;

public class Constants {
	
	// Spring Security

		public static final String LOGIN_URL = "${LOGIN_URL}";
		public static final String REGISTER_URL = "${REGISTER_URL}";
		public static final String BOOKS_URL = "${BOOKS_URL}";
		public static final String HEADER_AUTHORIZACION_KEY = "${HEADER_AUTHORIZACION_KEY}";
		public static final String TOKEN_BEARER_PREFIX = "${TOKEN_BEARER_PREFIX} ";

		// JWT

		public static final String ISSUER_INFO = "${ISSUER_INFO}";
		public static final String SUPER_SECRET_KEY = "${SUPER_SECRET_KEY}";
		public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

	

}
