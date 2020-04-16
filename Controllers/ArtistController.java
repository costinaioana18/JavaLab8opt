package com.company;

import java.sql.*;

/**
 * Gives the possibility of inserting an artist into the database
 */
public class ArtistController {
    private int idCounter = 0;
    private Connection connection;

    public int getArtistCounter() {
        return idCounter;
    }

    /**
     * The method increases the artists counter
     */
    public void increaseArtistCounter() {
        idCounter++;
    }

    public ArtistController(Connection connection) {
        this.connection = connection;
    }

    /**
     * The method creates a query used for inserting a new artist into the artists table
     *
     * @param artist the artists we want to insert in the database
     */
    public void insertArtist(Artist artist) {
        String command = "INSERT INTO artists(id, name, country) VALUES ( " + artist.getId() + "," + artist.getName() + "," + artist.getCountry() + ")";
        try {
            Statement stmt = connection.createStatement();
            int result = stmt.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
