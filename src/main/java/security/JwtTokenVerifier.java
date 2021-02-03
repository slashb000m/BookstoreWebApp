package security;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Strings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenVerifier /*extends OncePerRequestFilter*/ {

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//getting the request
//		String authorizationHeader = request.getHeader("Autorization");
//		if(Strings.isNullOrEmpty(authorizationHeader)|| !authorizationHeader.startsWith("Bearer")){
//			filterChain.doFilter(request, response);
//			return;
//		}
//		String token = authorizationHeader.replace("Bearer", "");
//		System.out.println(token);
//		try{
//			String secretKey = "Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3Mna3na3";
//			Jws<Claims> claimsJws = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
//					.parseClaimsJws(token);
//			Claims body = claimsJws.getBody();
//			String username = body.getSubject();
//		List<Map<String,String>> authorities = (List<Map<String,String>>)body.get("authorities");
//		Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
//				.map(m->new SimpleGrantedAuthority(m.get("Authority")))
//				.collect(Collectors.toSet());
//		Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		}catch(JwtException exception){
//			throw new IllegalStateException(String.format("untrusted token", token));
//		}
//		filterChain.doFilter(request, response);
//		
//	}
//	

}
