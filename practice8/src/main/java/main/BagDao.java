package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BagDao {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Bag> findAll() {
        List<Bag> bags = jdbcTemplate.query("select * from bag", new BeanPropertyRowMapper<>(Bag.class));
        return bags;
    }

    public int update(Bag bag) {
        return jdbcTemplate.update("UPDATE bag SET cost = ?, weight = ?, brand = ?, type = ?, color = ? "
                + "WHERE id = ?", new Object[] {
                bag.getCost(), bag.getWeight(), bag.getBrand(), bag.getType(), bag.getColor(), bag.getId()});
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM bag WHERE id = ?", new Object[] {id});
    }

    public List<Bag> findAllCostIncreaseThan(Double cost) {
        List<Bag> bags = jdbcTemplate.query(
                "select * from bag where cost>" + cost, new BeanPropertyRowMapper<>(Bag.class)
        );
        return bags;
    }

    public int insert(Bag bag) {
        return jdbcTemplate.update("INSERT INTO bag " + "(id, cost, weight, brand, type, color) "
        + "VALUES (?, ?, ?, ?, ?, ?)", new Object[] {
        bag.getId(), bag.getCost(), bag.getWeight(), bag.getBrand(), bag.getType(), bag.getColor()});
    }

}
