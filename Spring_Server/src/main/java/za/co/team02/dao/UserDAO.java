package za.co.team02.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.team02.model.SiteUser;

public interface UserDAO extends JpaRepository<SiteUser, Integer>
{
}
