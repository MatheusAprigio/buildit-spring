package br.com.buildit.security;

import br.com.buildit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (userRepository.findByEmailAndPassword(authentication.getName(), authentication.getCredentials().toString()) != null){
            SimpleGrantedAuthority role = new SimpleGrantedAuthority(
                    userRepository.findByEmailAndPassword(authentication.getName(), authentication.getCredentials().toString()).getRole().toString());

            List<SimpleGrantedAuthority> lstRoles = new ArrayList<>();
            lstRoles.add(role);

            String name = authentication.getName();
            String password = authentication.getCredentials().toString();

            return new UsernamePasswordAuthenticationToken(name, password, lstRoles);
        }else{
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
