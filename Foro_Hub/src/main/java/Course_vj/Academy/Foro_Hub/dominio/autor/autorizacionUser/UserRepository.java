package Course_vj.Academy.Foro_Hub.dominio.autor.autorizacionUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<AutorizacionUser, Long> {
    UserDetails findByLogin(String username);
}
