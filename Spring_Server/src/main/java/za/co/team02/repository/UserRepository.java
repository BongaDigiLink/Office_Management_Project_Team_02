package za.co.team02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.team02.model.SiteUser;

/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Integer> {
}
