package in.cmss.springsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;
import in.cmss.springsecurityjwt.models.AuthenticationRequest;
import in.cmss.springsecurityjwt.models.AuthenticationResponse;
import in.cmss.springsecurityjwt.services.MyUserDetailsService;
import in.cmss.springsecurityjwt.util.JwtUtil;
 

@RestController
public class Hello {
	
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Hello.class);

	@RequestMapping({ "/hello" })
	public String firstPage() {
		logger.info("loged in");
		return "Hello World";
	}
	
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private in.cmss.springsecurityjwt.services.ServiceA serrepository;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	/*
	@RequestMapping(value = "/add/{a}/{b}",method =RequestMethod.POST)
	public  int add(@PathVariable("a") int a, @PathVariable("b") int b) {
			 System.out.println("A is "+a+"B is "+b);
			 serrepository.Create(a, b);
		       return a+b; 
		        
		    }
*/
}


