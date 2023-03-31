package com.example.springdata.tennisplayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
 PlayerDAO interacts with the database
* */
@Repository
public class PlayerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private static final class PlayerMapper implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setNationality(rs.getString("nationality"));
            player.setDateBirth(rs.getDate("birth_date"));
            player.setTitles(rs.getInt("titles"));
            return player;
        }
    }


    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Player.class));
    }

    public Player getPlayerById(int playerId) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Player.class),
                playerId);
    }

    public List<Player> getPlayersByNationality(String nationality){
        String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
        return jdbcTemplate.query(sql, new PlayerMapper(),nationality);
    }

    public int addNewPlayer(Player player) {
        String sql = "INSERT INTO PLAYER(ID, Name, Nationality, Birth_date, Titles) " + "VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, player.getId(),
                player.getName(),
                player.getNationality(),
                player.getDateBirth(),
                player.getTitles());
    }

    public int updatePlayer(Player player) {
        String sql = "UPDATE PLAYER SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ? WHERE ID = ?";
        return jdbcTemplate.update(sql, player.getName(),
                player.getNationality(),
                player.getDateBirth(),
                player.getTitles(),
                player.getId());
    }

    public int deletePlayerById(int id) {
        String sql = "DELETE PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }

    public void createTournamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        LOGGER.info("TOURNAMENT Table was created");
    }


}
