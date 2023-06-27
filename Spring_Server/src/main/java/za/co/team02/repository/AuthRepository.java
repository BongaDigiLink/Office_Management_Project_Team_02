package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.SiteUser;

public interface AuthRepository extends JpaRepository<SiteUser, Integer>
{
    boolean existsByEmail(String email);

    SiteUser findByEmail(String email);
}
