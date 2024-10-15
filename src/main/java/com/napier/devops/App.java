package com.napier.devops;

import java.sql.*;

public class App {
    public static void main(String[] args) {

        App a = new App();

        // Connect to database
        a.connect();

        // Call Method (Report)
        a.countriesByContinent();

        // Disconnect from database
        a.disconnect();
    }
    private Connection con = null;
    /*
    Connect and Disconnect methods
    */
    //-----------------------------------------------------------------------------------
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database world in world-db
                con = DriverManager.getConnection("jdbc:mysql://world-db:3306/world?useSSL=false", "root", "p@sswdr00t");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    //-----------------------------------------------------------------------------------

    /*
    Reports
     */
    //-----------------------------------------------------------------------------------
    public void countriesByContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT Name AS country_name, "
                            + "Population "
                            + "FROM country "
                            + "WHERE Continent = 'Asia' "   //Asia can be changed to another Continent
                            + "ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println("All Countries by Continent:");

            // Header in SQL style
            System.out.printf("%-50s %-15s%n", "Country Name", "Population");
            System.out.println("-----------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String countryName = rset.getString("country_name");
                int population = rset.getInt("Population");
                System.out.printf("%-50s %-15d%n", countryName, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

