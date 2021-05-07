package cat.itb.oribetisprojectm9.seguretat;

import cat.itb.oribetisprojectm9.model.entitats.User;
import cat.itb.oribetisprojectm9.model.serveis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u= userService.findById(s);

        org.springframework.security.core.userdetails.User.UserBuilder builder=null;
        if(u!=null){
            builder= org.springframework.security.core.userdetails.User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        }
        else throw new UsernameNotFoundException("User no trobat");
        return builder.build();
    }
}
