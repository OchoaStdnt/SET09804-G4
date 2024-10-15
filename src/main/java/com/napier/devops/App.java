package com.napier.devops;
// Use case 1
import java.sql.*;

public class App {
    public static void main(String[] args) {

        App a = new App();

        // Connect to database
        a.connect();

        // Call Method (Report)
        a.topPopCitiesByRegion();

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
    public void topPopCitiesByRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS city_name, "
                            + "ci.Population "
                            + "FROM city ci "
                            + "JOIN country c ON ci.CountryCode = c.Code "
                            + "WHERE c.Name = 'United States' "   //United States can be changed to another Country
                            + "ORDER BY ci.Population DESC "
                            + "LIMIT 5";    //limit display
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println("Top Populated Cities by Region:");

            // Header in SQL style
            System.out.printf("%-50s %-15s%n", "City Name", "Population");
            System.out.println("-----------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("city_name");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-15d%n", cityName, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

