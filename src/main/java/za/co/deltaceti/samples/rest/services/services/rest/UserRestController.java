package za.co.deltaceti.samples.rest.services.services.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import za.co.deltaceti.samples.rest.security.JwtTokenUtil;
import za.co.deltaceti.samples.rest.security.JwtUser;

@Api("User services")
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private static Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(@ApiParam(value = "Authorization token", required = true) @RequestHeader("Authorization") final String authorization, final HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return (JwtUser) userDetailsService.loadUserByUsername(username);
    }

}
