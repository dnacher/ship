package com.ship.ship.jwt.filters;

import com.ship.ship.constants.JwtConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String authHeader = httpServletRequest.getHeader("Authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                "content-type, x-gwt-module-base, x-gwt-permutation, clientid, longpush");

        if (authHeader != null) {
            String[] authHeaderArr = authHeader.split("Bearer ");
            if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {
                String token = authHeaderArr[1];
                try {
                    Claims claims = Jwts.parser()
                            .setSigningKey(JwtConstants.API_SECRET_KEY)
                            .parseClaimsJws(token).getBody();
                    httpServletRequest.setAttribute("user", (claims.get("User").toString()));
                } catch (Exception e) {
                    httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid or expired token");
                    return;
                }
            } else {
                httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "Missing token");
                return;
            }
        } else {
            httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "Header must be provided");
            return;
        }
        chain.doFilter(httpServletRequest, httpServletResponse);
    }
}
