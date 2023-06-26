package za.co.team02.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import za.co.team02.model.SiteUser;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<SiteUser> {
    @Override
    public SiteUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        SiteUser user = new SiteUser();
        user.setEmail(rs.getString("EMAIL"));
        user.setFirstName(rs.getString("FIRST_NAME"));
        user.setLastName(rs.getString("LAST_NAME"));
        user.setUsername(rs.getString("USERNAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setRole(rs.getString("ROLE"));
        user.setAddress(rs.getString("USER_ADDRESS"));
        return user;
    }
}
