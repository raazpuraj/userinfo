package com.user.userinfo.utility;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class TokenService {
	public String createJWT( String issuer, String subject, long ttlMillis) {
		final  String lock="32847239842asdjfascbzxcuaq"; 
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	 
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	 
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(lock);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	 
	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder()
	                                .setIssuedAt(now)
	                                .setSubject(subject)
	                                .setIssuer(issuer)
	                                .signWith(signatureAlgorithm, signingKey);
	 
	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	 
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}

	public HashMap parseJWT(String jwt) {
		 
	        HashMap h=new HashMap();  
		//This line will throw an exception if it is not a signed JWS (as expected)
	    try {
	    	Claims claims = Jwts.parser()         
	    		       .setSigningKey(DatatypeConverter.parseBase64Binary("32847239842asdjfascbzxcuaq"))
	    		       .parseClaimsJws(jwt).getBody();


	    		    h.put("status", 1);
	                return h;
	    }
	        
	    catch (Exception e) {
		    h.put("status", 0);
	    return h;	
	    }
	    finally {
			System.out.println("inside token parse method in java");
		}
	  
	}
}

