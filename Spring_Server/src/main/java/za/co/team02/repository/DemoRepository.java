package za.co.team02.repository;

import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import za.co.team02.model.SiteUser;

public class DemoData {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DemoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveContactMsg(SiteUser siteUser){
        String sql = "INSERT INTO USERS(EMAIL, FIRST_NAME, LAST_NAME, PASSWORD,ROLE,USER_ADDRESS, USERNAME)\n" +
                "VALUES ('bonga@gmail.com','Bonga','Gougota','bonga@gmail.com','user', 'Ameshoff JHB','@Bongag'),\n" +
                "('hloni@gmail.com','Hloni','Moloi','hloni@gmail.com','admin', 'Ameshoff JHB','@hloni');";
        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),
                contact.getEmail(),contact.getSubject(),contact.getMessage(),
                contact.getStatus(),contact.getCreatedAt(),contact.getCreatedBy());
    }



}
