package com.pacoteck.springboot.app.security;

import static com.pacoteck.springboot.app.security.Constants.HEADER_AUTHORIZACION_KEY;
import static com.pacoteck.springboot.app.security.Constants.SUPER_SECRET_KEY;
import static com.pacoteck.springboot.app.security.Constants.TOKEN_BEARER_PREFIX;
import static com.pacoteck.springboot.app.security.Constants.ISSUER_INFO;
import static com.pacoteck.springboot.app.security.Constants.TOKEN_EXPIRATION_TIME;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
public class JWTAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	//Este método es el que controla la autentificación
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			//Aquí tomo el usuario enviador por el body
			com.pacoteck.springboot.app.dto.User credenciales = new ObjectMapper().readValue(request.getInputStream(), com.pacoteck.springboot.app.dto.User.class);
			
			//Creo una instancia de usernamePassworAuthenticationToken que es enviada a authenticate para verificar las credenciales
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//En caso de autentificarse con éxito, este método genera el token y lo devuelve
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		//Retorno le usuario para el que estoy creando el token
		User user = (User) auth.getPrincipal();
		
		String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
		System.out.println("roles cuando se crea el token: " + authorities);
		//Creo el token
		String token = Jwts.builder()
				.setIssuedAt(new Date()) //Agrego fecha de creación
				.setIssuer(ISSUER_INFO) //Agrego la información del creador (puede ser el nombre de la compañía o dueño de la API
				.setSubject(user.getUsername()) //Le agrego el usuario para poder identificarlo luego
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME)) //Seteo el tiempo de expiración del token
				.claim("roles", authorities) //Agrego los roles del usuario al token
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact(); //Lo firmo con el algoritmo HS512
		
		//Devuelvo el token por cabecera "authorization":"bearer + token"
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
		response.getWriter().write("{\"token\": \"" + token + "\"}");//y también lo devuelve por el body
	
	}
}
