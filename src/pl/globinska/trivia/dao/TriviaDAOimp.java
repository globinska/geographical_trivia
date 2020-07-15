package pl.globinska.trivia.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.globinska.trivia.model.Trivia;
import pl.globinska.trivia.util.ConnectionProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriviaDAOimp implements TriviaDAO {

    private static final String CREATE_TRIVIA = "INSERT INTO trivia(name,description, url, userID, date, thumbs_up, thumbs_down)" + "VALUES(:name, :description, :url, :userID, :date, :thumbs_up, :thumbs_down);";

    private NamedParameterJdbcTemplate template;

    public TriviaDAOimp() {
        template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public List<Trivia> getAll() {
        return null;
    }

    @Override
    public Trivia create(Trivia trivia) {
        Trivia resultTrivia = new Trivia(trivia);
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("name", trivia.getTriviaName());
        paramMap.put("description", trivia.getTriviaDescription());
        paramMap.put("url", trivia.getTriviaUrl());
        paramMap.put("userID", trivia.getTriviaId());
        paramMap.put("date", trivia.getTriviaTime());
        paramMap.put("thumbs_up", trivia.getUpvote());
        paramMap.put("thumbs_down", trivia.getDownvote());
        SqlParameterSource parameterSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_TRIVIA, parameterSource, holder);
        if (update >0){
            resultTrivia.setTriviaId((int) holder.getKey().longValue());
        }
        return resultTrivia;
    }

    @Override
    public Trivia read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Trivia updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }
}
