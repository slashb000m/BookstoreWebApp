package jwt;

import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.IOException;
import io.jsonwebtoken.security.Keys;




public class JwtusernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;
	public JwtusernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager = authenticationManager;
		// link of authentication process delivered by spring security
		setFilterProcessesUrl("/api/auth/login");
		// TODO Auto-generated constructor stub
	}
	//Methods job is to get the AuthenticationRequest and verify the credentials sent by the Client-Side
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated  method stub
		
		try{
		UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
				.readValue(request.getInputStream(),UsernameAndPasswordAuthenticationRequest.class );
		Authentication authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		
		Authentication authenticate = authenticationManager.authenticate(authentication);
		
		return authenticate;
		}catch(java.io.IOException e){
			throw new RuntimeException(e);
		}
//		catch(AuthenticationException exception){
//			exception.getMessage();
//		}
		

	}
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws java.io.IOException, ServletException {
		// TODO Auto-generated method stub
		String key ="Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3";
		String token = Jwts.builder().setSubject(authResult.getName()).claim("authorities", authResult.getAuthorities())
				.setIssuedAt(new Date()).setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
				.signWith(Keys.hmacShaKeyFor(key.getBytes())).compact();
		response.addHeader("Authorization", "Bearer"+ token);
		response.getWriter().write(token);
		response.getWriter().flush();
	}

}
