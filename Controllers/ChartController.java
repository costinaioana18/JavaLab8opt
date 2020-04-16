package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gives the possibility of inserting a new chart into the database
 */
public class ChartController {
    private Connection connection;

    public ChartController(Connection connection) {
        this.connection = connection;
    }

    /**
     * Creates a query that inserts a new chart into the charts table
     *
     * @param chart the chart we want to insert into the database
     */
    public void insertChart(Chart chart) {
        String command = "INSERT INTO charts VALUES ( albums_id_list(" + chart.getAlbumsId() + "))";
        try {
            Statement stmt = connection.createStatement();
            int result = stmt.executeUpdate(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
