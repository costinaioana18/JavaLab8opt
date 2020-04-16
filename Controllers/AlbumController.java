package com.company;

import java.sql.*;

/**
 * Gives the possibility of inserting an album into the database
 */
public class AlbumController {
    private int idCounter = 0;
    private Connection connection;

    public AlbumController(Connection connection) {
        this.connection = connection;
    }

    public int getAbumCounter() {
        return idCounter;
    }

    /**
     * the method increases the albums counter
     */
    public void increaseAlbumCounter() {
        idCounter++;
    }

    /**
     * The method creates a query used for inserting a new album into the albums table
     *
     * @param album the album we want to insert in the database
     */
    public void insertAlbum(Album album) {
        String command = "INSERT INTO albums(id, name, artist_id, release_year) VALUES ( " + album.getId() + "," + album.getName() + "," + album.getArtistId() + "," + album.getReleaseYear() + ")";
        try {
            Statement stmt = connection.createStatement();
            int result = stmt.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
