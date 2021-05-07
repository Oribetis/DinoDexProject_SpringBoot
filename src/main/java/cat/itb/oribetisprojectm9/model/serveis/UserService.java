package cat.itb.oribetisprojectm9.model.serveis;

import cat.itb.oribetisprojectm9.model.entitats.User;
import cat.itb.oribetisprojectm9.model.repositoris.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repositori;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registrar(User u) throws Exception{
        User j=repositori.findByUsername(u.getUsername());
        if(j==null) {
            u.setPassword(passwordEncoder.encode(u.getPassword()));
            repositori.save(u);
        }
        else throw new Exception("User ja existent");
    }

    public User findById(String username) {
        return repositori.findByUsername(username);
    }

}
