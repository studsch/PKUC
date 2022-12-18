package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Set;

@Component
public class UserDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> findAll() {
        List<User> users = jdbcTemplate.query("select email, phone_number, name, active, password, role from usr", new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    public boolean checkedUser(String email) {
        boolean exist = jdbcTemplate.queryForObject("SELECT EXISTS (select * from usr where email = ?)", boolean.class, new Object[] {email});
        return exist;
    }

    public User findByEmail(String email) {
        User user = (User) jdbcTemplate.queryForObject("select email, phone_number, name, active, password, role from usr where email = ?", new BeanPropertyRowMapper<>(User.class), new Object[] {email});
        return user;
    }

    public int delete(String email) {
        return jdbcTemplate.update("DELETE FROM usr WHERE email = ?", new Object[] {email});
    }

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (this.checkedUser(email)) return false;
        user.setActive(true);
        user.setRole("USER");
        System.out.println(user.getRole().toString());
        jdbcTemplate.update("INSERT INTO usr " + "(email, phone_number, name, active, password, role) "
                + "VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
                user.getEmail(), user.getPhoneNumber(), user.getName(), user.isActive(), user.getPassword(),
                user.getRole().toString()
        });
        return true;
    }

}
