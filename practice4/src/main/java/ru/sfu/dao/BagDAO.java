package ru.sfu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sfu.models.Bag;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BagDAO {
    private static int BAG_COUNT;
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(Bag bag) {
        bag.setId(++BAG_COUNT);
        jdbcTemplate.update("insert into bag " +
                        "(id, material, brand, country, height, width, depth) " +
                        "values (?, ?, ?, ?, ?, ?, ?)",
                bag.getId(),
                bag.getMaterial(),
                bag.getBrand(),
                bag.getCountry(),
                bag.getHeight(),
                bag.getWidth(),
                bag.getDepth());
    }

    public List<Bag> index() {
        return jdbcTemplate.query("SELECT * FROM bag",
                new BeanPropertyRowMapper<>(Bag.class));
    }

    public void update(int id, Bag bag) {
        jdbcTemplate.update("UPDATE bag SET " +
                        "material=?, brand=?, country=?, height=?, width=?, depth=? " +
                        "WHERE id=?",
                bag.getMaterial(),
                bag.getBrand(),
                bag.getCountry(),
                bag.getHeight(),
                bag.getWidth(),
                bag.getDepth(),
                id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM bag WHERE id=?", id);
    }

    public Bag show(int height) {
        return jdbcTemplate.query("SELECT * FROM bag WHERE height<?",
                        new Object[]{height}, new BeanPropertyRowMapper<>(Bag.class))
                .stream().findAny().orElse(null);
    }
}
