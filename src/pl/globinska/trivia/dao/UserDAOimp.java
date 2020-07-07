package pl.globinska.trivia.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.globinska.trivia.model.User;
import pl.globinska.trivia.util.ConnectionProvider;

import java.util.List;

public class UserDAOimp implements UserDAO{

    private static final String CREATE_USER = "INSERT INTO user(username, email, password, isactive) VALUES(:username, :email, :password, :active);";

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
        return null;
    }
}
