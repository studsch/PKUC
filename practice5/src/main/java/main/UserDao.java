package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDao {
    private static int USER_COUNT;

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(User user) {
        user.setId(++USER_COUNT);
        jdbcTemplate.update("insert into myuser " +
                        "(id, login, password, role) " +
                        "values (?, ?, ?, ?)",
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRole().toString());
    }
}
