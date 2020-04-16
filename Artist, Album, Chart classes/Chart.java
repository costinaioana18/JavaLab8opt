package com.company;

import java.util.ArrayList;

/**
 * It holds an album array list
 * it adds different albums into the charts and adds a different value to the artists rank, considering their position in the charts
 */
public class Chart {
    private ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<Artist> artists;
    private int albumCounter = 0;

    public Chart(ArrayList<Artist> artisti) {
        artists = artisti;
    }

    /**
     * The method adds an album in the chart
     * The method adds a specific value to the artists rank,considering their position in the chart( albums ArrayList)
     *
     * @param album - the album we add in the chart
     */
    public void addAlbum(Album album) {
        albums.add(album);
        albumCounter++;
        int artistId = album.getArtistId();
        for (Artist a : artists) {
            if (a.getId() == artistId)
                a.increaseRank(100 / albumCounter);
        }
    }

    /**
     * The method prints the albums a chart contains (and their artists)
     */
    public void printChart() {
        System.out.println("One of the charts contains the following albums: " + albums);
    }

    /**
     * The method is used when we create the query that inserts the chart into the database
     *
     * @return a string containing the albums' ids the chart has
     */
    public String getAlbumsId() {
        String albumsList = "";
        for (Album album : albums)
            albumsList = albumsList + album.getId() + " , ";
        albumsList = albumsList.substring(0, albumsList.length() - 2);
        return albumsList;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "albums=" + albums +
                '}';
    }
}
