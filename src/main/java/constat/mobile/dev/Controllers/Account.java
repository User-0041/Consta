package constat.mobile.dev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.Account ;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Account {

    @Autowired
    private User user;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/Account")
    public ResponseEntity<?> authenticate(@RequestBody Account account) {
        try {
             account.authenticate(
                    new UsernamePasswordAuthenticationToken(account.getUser(),account.getPassword())
            );

            // Authentication successful, generate JWT token
            final String token = jwtTokenUtil.generateToken(account.getUser());
            return ResponseEntity.ok(new Account(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
