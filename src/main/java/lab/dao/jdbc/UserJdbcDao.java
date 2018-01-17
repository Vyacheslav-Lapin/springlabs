package lab.dao.jdbc;

import lab.dao.UserDao;
import lab.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

@Log4j2
public class UserJdbcDao extends JdbcDaoSupport implements UserDao {

    private static final RowMapper<User> USER_MAPPER = (rs, i) ->
            new User(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));

    @Override
    public void insert(User user) {

        if (user == null)
            log.debug("Domain user is null!");
        else {
            log.debug(() -> "Processing user: " + user);
            getJdbcTemplate().update(
                    "INSERT INTO user (first_name, last_name) VALUES (?, ?)",
                    user.getFirstName(), user.getLastName());

        }
    }

    @Override
    public User select(int id) {

        assert id > 0;

        User user = getJdbcTemplate().queryForObject(
                    "SELECT id, first_name, last_name FROM user WHERE id = ?",
                    new Object[]{id}, USER_MAPPER);

        log.debug(() -> "Received user: " + user);

        return user;
    }

    @Override
    public List<User> selectAll() {
        return getJdbcTemplate().query(
                "SELECT id, first_name, last_name FROM user", USER_MAPPER);
    }
}
