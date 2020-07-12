package pl.globinska.trivia.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.globinska.trivia.model.User;
import pl.globinska.trivia.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOimp implements UserDAO{

    private static final String CREATE_USER = "INSERT INTO user(username, email, password, isactive) VALUES(:username, :email, :password, :active);";
    private static final String READ_USER = "SELECT userID, username, email, password, isactive FROM user WHERE userID=:id";
    private static final String READ_USER_BY_USERNAME = "SELECT userID, username, email, password, isactive FROM user WHERE username=:username";

    private NamedParameterJdbcTemplate template;

    public UserDAOimp() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public User create(User user) {
        User resultUser = new User(user);
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        int update = template.update(CREATE_USER,parameterSource,holder);
        if (update >0){
            resultUser.setUserId((int) holder.getKey().longValue());
            setPriviliges(resultUser);
        }
        return resultUser;
    }

    private void setPriviliges(User user){
        final String userRoleQuery = "INSERT INTO user_role(username) VALUES (:username)";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        template.update(userRoleQuery, parameterSource);
    }

    @Override
    public User read(Long primaryKey) {
        User resultUser = null;
        SqlParameterSource parameterSource = new MapSqlParameterSource("id",primaryKey);
        resultUser = template.queryForObject(READ_USER, parameterSource, new UserRowMapper());
        return null;
    }

    @Override
    public boolean update(User updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        User resultUser = null;
        SqlParameterSource parameterSource = new MapSqlParameterSource("username", username);
        resultUser = template.queryForObject(READ_USER_BY_USERNAME, parameterSource, new UserRowMapper());
        return resultUser;
    }

    private class UserRowMapper implements RowMapper<User>{

        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId((int) resultSet.getLong("userID"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }


}


