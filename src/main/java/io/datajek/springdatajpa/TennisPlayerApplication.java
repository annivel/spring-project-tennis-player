package io.datajek.springdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

//@SpringBootApplication
public class TennisPlayerApplication implements CommandLineRunner {
    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerRepository playerRepository;
    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Djokovic", "Serbia", Date.valueOf("1987-05-22"), 81)));

        LOGGER.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Monfils", "France", Date.valueOf("1986-09-01"), 10)));

        LOGGER.info("\n\n>> Player with id 2: {}\n", playerRepository.getPlayerById(2));

        LOGGER.info("\n\n>> Updating player: {}\n", playerRepository.updatePlayer(
                new Player(1,"Djokovic", "Ukraine", Date.valueOf("1987-05-22"), 81)));

        LOGGER.info("\n\n>> Inserting Player: {}\n", playerRepository.insertPlayer(
                new Player("Test", "Test", Date.valueOf("2023-03-27"), 0)));

        playerRepository.deleteById(3);

        LOGGER.info("All Players Data: {}", playerRepository.getAllPlayers());

    }
}
