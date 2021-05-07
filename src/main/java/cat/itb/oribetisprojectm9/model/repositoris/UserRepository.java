package cat.itb.oribetisprojectm9.model.repositoris;

import cat.itb.oribetisprojectm9.model.entitats.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
