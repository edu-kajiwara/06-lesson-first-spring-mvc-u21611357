package tama.ac.jp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import tama.ac.jp.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kajiwarayutaka on 2017/05/09.
 */
@Service
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> selectUserList(){
        return jdbcTemplate.query("SELECT * FROM user;", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("user_id"),rs.getString("user_name"));
                return user;
            }
        });
    }

    public User selectUser(String userId){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM user where user_id = ?",
                new BeanPropertyRowMapper<>(User.class),
                userId);
    }

    public void insertUser(User user){
        jdbcTemplate.update(
                "INSERT INTO user(user_id, user_name) VALUES (?,?)",
                user.getUser_id(),user.getUser_name());
    }


    public void updateUser(User user){
        jdbcTemplate.update(
                "UPDATE user SET user_name=? WHERE user_id = ?",
                user.getUser_name(),user.getUser_id());
    }

    public void deleteUser(String userId){
        jdbcTemplate.update(
                "DELETE FROM user WHERE user_id = ?",
                userId);
    }
}
