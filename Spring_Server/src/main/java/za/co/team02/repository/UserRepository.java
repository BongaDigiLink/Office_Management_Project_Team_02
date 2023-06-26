package za.co.team02.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import za.co.team02.model.SiteUser;
/*
@Repository stereotype annotation is used to add a bean of this class
type to the Spring context and indicate that given Bean is used to perform
DB related operations and
* */

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveUser(SiteUser user){
        String sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,USERNAME,PASSWORD,EMAIL,ROLE,USER_ADDRESS) " +
                "VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,user.getFirstName(),user.getLastName(),user.getUsername(),user.getPassword(),user.getEmail(),
                user.getRole(),user.getAddress());
    }
}
