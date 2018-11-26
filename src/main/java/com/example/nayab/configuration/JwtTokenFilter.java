package com.example.nayab.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.SignatureException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtTokenFilter extends GenericFilterBean {


    private JwtTokenProvider jwtTokenProvider;

    private static  final Logger log = LogManager.getLogger(JwtTokenFilter.class);

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        log.info("Entering into JwtTokenFilter inside constructor");
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {

        log.info("Entering into JwtTokenFilter inside method doFilter");

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);

        try {
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication auth = token != null ? jwtTokenProvider.getAuthentication(token) : null;
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        catch (SignatureException e){
            e.printStackTrace();
        }
        log.info("Exsting from  JwtTokenFilter from method doFilter");
        filterChain.doFilter(req, res);
    }
}
