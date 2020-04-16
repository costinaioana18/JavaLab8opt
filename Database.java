package com.company;

import java.sql.*;
import java.util.ArrayList;

/**
 * A singleton class which creates its own single instance
 * It has a login method and a functionality testing method, using the DAO classes ArtistController and AlbumController
 */
public final class Database {
    private static final Database database = new Database();
    private static Connection connection;

    private Database() {
    }

    public static Database getDatabase() {
        return database;
    }

    /**
     * The method loads the database driver
     * It creates the connection on the MusicAlbums database, with the user "dbase" and the password "sql"
     * If the parameters are not right the connection the user will be notified
     *
     * @param user     the database user
     * @param password the database password
     */
    public void logIn(String user, String password) {

        if (user.equals("dbase") && password.equals("sql")) {
            System.out.println("Connected");
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {

                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:MusicAlbums", "dbase", "sql");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else
            System.out.println("Wrong user or password");

    }

    /**
     * The method creates an ArtistController, an AlbumController and a ChartController
     * It randomly generates artists and albums and adds the to the data base
     * It creates 2 charts and adds them to the database
     * It prints the generated data
     */
    public void testFunctionality() {

        ArtistController artistController = new ArtistController(connection);
        AlbumController albumController = new AlbumController(connection);
        ChartController chartController = new ChartController(connection);

        ArrayList<Artist> artists = new ArrayList<>();
        Artist artist = new Artist(artistController);
        Artist artist1 = new Artist(artistController);
        Artist artist2 = new Artist(artistController);
        Album album1 = new Album(albumController, artistController);
        Album album2 = new Album(albumController, artistController);
        Album album3 = new Album(albumController, artistController);
        Album album4 = new Album(albumController, artistController);
        Chart chart = new Chart(artists);
        Chart chart2 = new Chart(artists);

        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist);

        artist.randomGenerate();
        artist1.randomGenerate();
        artist2.randomGenerate();
        album1.randomGenerate();
        album2.randomGenerate();
        album3.randomGenerate();
        album4.randomGenerate();

        chart.addAlbum(album1);
        chart.addAlbum(album2);
        chart2.addAlbum(album2);
        chart2.addAlbum(album3);
        chart2.addAlbum(album4);

        chartController.insertChart(chart);
        chartController.insertChart(chart2);

        System.out.println("Albums:");
        album1.printAlbum();
        album2.printAlbum();
        album3.printAlbum();
        album4.printAlbum();

        System.out.println("Charts: ");
        chart.printChart();
        chart2.printChart();

        System.out.println("Artists: ");
        artist.printArtist();
        artist1.printArtist();
        artist2.printArtist();

    }
}
