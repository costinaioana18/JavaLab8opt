package com.company;


import java.util.Random;

/**
 * It holds an album's info
 * Gives the possibility of creating a random generated set of info
 */
public class Album {
    private int id;
    private String name;
    private int artistId;
    private int releaseYear;
    private AlbumController albumController;
    private ArtistController artistController;

    public Album(AlbumController albumController, ArtistController artistController) {
        this.albumController = albumController;
        this.artistController = artistController;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getArtistId() {
        return artistId;
    }

    /**
     * The method sets the albums's id considering the id it gets from the albumController
     * It randomly sets a name, a release year and an artist id(one of the existing ones)
     * It inserts the album into the database
     */
    public void randomGenerate() {
        this.id = albumController.getAbumCounter() + 1;
        albumController.increaseAlbumCounter();

        Random rand = new Random();
        int rand1 = rand.nextInt(30);
        this.releaseYear = 1990 + rand1;

        int artistsNo = artistController.getArtistCounter();
        int rand2 = rand.nextInt(artistsNo);
        this.artistId = rand2 + 1;

        int rand3 = rand.nextInt(30);
        String[] nameArray = {"Lullaby", "Greatest power", "Will you", "Under the stars", "Where you are", "Hence the love is here", "Sher mon cher", "Listen to your heart", "Under your stars", "City lights", "Basic peculiar", "Work", "Believable", "Traditional change", "Let him go", "Fly high", "Hope you ll be there", "Follow the music", "Be yourself", "Look at the moon", "Beautiful mornings", "Say my name", "Smile and leave", "Joy to the world", "Zach", "Love is where you are", "Mystery", "Christmas is here", "Falling in love", "Seeing the future"};
        this.name = nameArray[rand3];

        albumController.insertAlbum(this);

    }

    /**
     * The method prints the album's info
     */
    public void printAlbum() {
        System.out.println("Id: " + this.id + ", name: \"" + this.name + "\", release year: " + this.releaseYear + ", artist's id: " + this.artistId);
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\"" + " by artists with id: " + this.artistId;
    }
}
