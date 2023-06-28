package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.team02.model.SiteUser;

import java.util.Collection;
import java.util.List;

/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Integer> {

    @Query("SELECT u FROM users u WHERE u.role = 'user' ")
    Collection<SiteUser> getSiteUsersByRole();
}
