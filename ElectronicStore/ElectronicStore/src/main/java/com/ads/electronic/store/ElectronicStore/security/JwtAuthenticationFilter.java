package com.ads.electronic.store.ElectronicStore.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
      String requestHeader = request.getHeader("Authorization");
      logger.info("Header {} ",requestHeader);
      String username = null;
      String token = null;
      //Bearer hgewkjfhas
      if (requestHeader != null && requestHeader.startsWith("Bearer")){
          token= requestHeader.substring(7);
          try {
              username = jwtHelper.getUsernameFromToken(token);
          }
          catch (IllegalArgumentException ex){
              logger.info("Illegal Argument Exception while fetching the username!!");
              ex.printStackTrace();
          }
          catch (ExpiredJwtException ex){
              logger.info("Given JWT Token has been expired!!");
              ex.printStackTrace();
          }
          catch (MalformedJwtException ex){
              logger.info("Some change done in token!! Invalid token");
              ex.printStackTrace();
          }
      }
      else {
          logger.info("Invalid header value!!");
      }
      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
          //Fetch the users details from username
          UserDetails userDetails = userDetailsService.loadUserByUsername(username);
          Boolean isValidToken = jwtHelper.validateToken(token,userDetails);
          if (isValidToken){
              //set the authentication
              UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
              authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
              SecurityContextHolder.getContext().setAuthentication(authentication);
          }
          else {
              logger.info("validation failed!!");
          }
      }
      filterChain.doFilter(request,response);
    }
}
