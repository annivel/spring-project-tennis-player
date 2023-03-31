package io.datajek.springdatajpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {
    @PersistenceContext // All operations that are performed in a specific session are stored inside the PersistenceContext
    EntityManager entityManager; // manages connection to a database as well as to database operations.

    public Player insertPlayer(Player player){
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player){
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id){
        return entityManager.find(Player.class, id);
    }

    public void deleteById(int id){
        Player player = entityManager.find(Player.class, id);
        entityManager.remove(player);
    }

    public List<Player> getAllPlayers(){
        TypedQuery<Player> getAllPlayers = entityManager.createNamedQuery("get_all_players", Player.class);
        return getAllPlayers.getResultList();
    }

}
