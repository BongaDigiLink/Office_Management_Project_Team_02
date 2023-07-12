package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.team02.model.SiteUser;
import java.util.Collection;
import java.util.Optional;

/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Integer> {

    Optional<SiteUser> findByEmail(String email);

    @Query("SELECT u FROM userss u WHERE u.role = 'user' ")
    Collection<SiteUser> getSiteUsersByRole();

}
