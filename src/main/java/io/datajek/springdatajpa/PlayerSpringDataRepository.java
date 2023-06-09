package io.datajek.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface PlayerSpringDataRepository extends JpaRepository<Player,Integer> {
    public List<Player> findByNationality(String nationality);
}
