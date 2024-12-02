/**
 *  This file contains all the Methods that are called from the App.java file and the Menu.java.
 *  Methods in this file are all the 32 reports called from the Menu.java.
 *  Other methods here are for connecting and disconnecting to the World DB.
 *  Methods for accepting a user input that is passed on some methods to limit display of reports.
 *  A method to test connection to the database by showing tables of world DB
 */

package com.napier.devops;
import java.sql.*;
import java.util.Scanner;

public class Methods {

    private Connection con = null;

    /* add colors to the system out */
    final String RESET = "\u001B[0m";
    final String BLUE = "\u001B[34m";
    final String GREEN = "\u001B[32m";
    final String RED = "\u001B[31m";

    //-------------- Method 1 - All Countries by Population ------------------
    //-------------- Angel Ochoa --------------------
    public void allCountriesByPop()
    {
        try
        {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            /* Create string for SQL statement */
            String strSelect =
                    /* SQL query */
                    "SELECT Code, "
                            + "Name AS country_name, "
                            + "Continent, "
                            + "Region, "
                            + "Population, "
                            + "Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC";
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);

            /* Report Name */
            System.out.println(GREEN + "All Countries by Population:" + RESET);

            /* Header in SQL style */
            System.out.printf("%-5s %-50s %-20s %-40s %-15s %-6s%n", "Code", "Country Name", "Continent", "Region", "Population", "Capital");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            /* Print data */
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("country_name");
                String conti = rset.getString("Continent");
                String regn = rset.getString("Region");
                int population = rset.getInt("Population");
                int countryCapital = rset.getInt("Capital");
                System.out.printf("%-5s %-50s %-20s %-40s %-15d %-6d%n", countryCode, countryName, conti, regn, population, countryCapital);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 1 ------------------------------

    //-------------- Method 2 - All countries by continent (Using Asia)------------------
    //-------------- Donisio Rash --------------------
    public void countriesByContinent()
    {
        try
        {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            /* Create string for SQL statement */
            String strSelect =
                    /* SQL query */
                    "SELECT Code, "
                            + "Name AS country_name, "
                            + "Continent, "
                            + "Region, "
                            + "Population, "
                            + "Capital "
                            + "FROM country "
                            + "WHERE Continent = 'Asia' "   //Asia can be changed to another Continent
                            + "ORDER BY Population DESC";
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);

            /* Report Name */
            System.out.println(GREEN + "All countries by continent (Using Asia):" + RESET);

            /* Header in SQL style */
            System.out.printf("%-5s %-50s %-20s %-40s %-15s %-6s%n", "Code", "Country Name", "Continent", "Region", "Population", "Capital");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            /* Print data */
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("country_name");
                String conti = rset.getString("Continent");
                String regn = rset.getString("Region");
                int population = rset.getInt("Population");
                int countryCapital = rset.getInt("Capital");
                System.out.printf("%-5s %-50s %-20s %-40s %-15d %-6d%n", countryCode, countryName, conti, regn, population, countryCapital);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 2 ------------------------------\

    //-------------- Method 3 - All countries by Region ------------------
    //-------------- Donisio Rash --------------------
    public void countriesByRegion()
    {
        try
        {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            /* Create string for SQL statement */
            String strSelect =
                    /* SQL query */
                    "SELECT Code, "
                            + "Name AS country_name, "
                            + "Continent, "
                            + "Region, "
                            + "Population, "
                            + "Capital "
                            + "FROM country "
                            + "WHERE Region = 'Caribbean' "   //Caribbean can be changed to another region
                            + "ORDER BY Population DESC";
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);

            /* Report Name */
            System.out.println(GREEN + "All countries by Region:" + RESET);

            /* Header in SQL style */
            System.out.printf("%-5s %-50s %-20s %-40s %-15s %-6s%n", "Code", "Country Name", "Continent", "Region", "Population", "Capital");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            /* Print data */
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("country_name");
                String conti = rset.getString("Continent");
                String regn = rset.getString("Region");
                int population = rset.getInt("Population");
                int countryCapital = rset.getInt("Capital");
                System.out.printf("%-5s %-50s %-20s %-40s %-15d %-6d%n", countryCode, countryName, conti, regn, population, countryCapital);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 3 ------------------------------

    //-------------- Method 4 - Top populated countries in world ------------------
    //-------------- Donisio Rash --------------------
    public void topPopCountriesInWorld() {
        int userVal = getNum(); // for N value
        try {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            /* Create string for SQL statement */
            String strSelect =
                    /* SQL query */
                    "SELECT Code, "
                            + "Name AS country_name, "
                            + "Continent, "
                            + "Region, "
                            + "Population, "
                            + "Capital "
                            + "FROM country "
                            + "ORDER BY Population DESC "
                            + "LIMIT " + userVal;   //limit display
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);

            /* Report Name */
            System.out.println(GREEN + "Top populated countries in world:" + RESET);

            /* Header in SQL style */
            System.out.printf("%-5s %-50s %-20s %-40s %-15s %-6s%n", "Code", "Country Name", "Continent", "Region", "Population", "Capital");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            /* Print data */
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("country_name");
                String conti = rset.getString("Continent");
                String regn = rset.getString("Region");
                int population = rset.getInt("Population");
                int countryCapital = rset.getInt("Capital");
                System.out.printf("%-5s %-50s %-20s %-40s %-15d %-6d%n", countryCode, countryName, conti, regn, population, countryCapital);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 4 ------------------------------

    //-------------- Method 5 - Top populated countries by Continent ------------------
    //-------------- Donisio Rash --------------------
    public void topPopCountriesByContinent() {
        int userVal = getNum(); // for N value
        try {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            /* Create string for SQL statement */
            String strSelect =
                    /* SQL query */
                    "SELECT Code, "
                            + "Name AS country_name, "
                            + "Continent, "
                            + "Region, "
                            + "Population, "
                            + "Capital "
                            + "FROM country "
                            + "WHERE Continent = 'Asia' "   //Asia can be changed to another Continent
                            + "ORDER BY Population DESC "
                            + "LIMIT " + userVal;   //limit display
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);

            /* Report Name */
            System.out.println(GREEN + "Top populated countries by Continent:" + RESET);

            /* Header in SQL style */
            System.out.printf("%-5s %-50s %-20s %-40s %-15s %-6s%n", "Code", "Country Name", "Continent", "Region", "Population", "Capital");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            /* Print data */
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("country_name");
                String conti = rset.getString("Continent");
                String regn = rset.getString("Region");
                int population = rset.getInt("Population");
                int countryCapital = rset.getInt("Capital");
                System.out.printf("%-5s %-50s %-20s %-40s %-15d %-6d%n", countryCode, countryName, conti, regn, population, countryCapital);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 5 ------------------------------

    //-------------- Method 6 - Top populated countries by Region ------------------
    //-------------- Donisio Rash --------------------
    public void topPopCountriesByRegion() {
        int userVal = getNum(); // for N value
        try {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            /* Create string for SQL statement */
            String strSelect =
                    /* SQL query */
                    "SELECT Code, "
                            + "Name AS country_name, "
                            + "Continent, "
                            + "Region, "
                            + "Population, "
                            + "Capital "
                            + "FROM country "
                            + "WHERE Region = 'Caribbean' "   //Caribbean can be changed to another Region
                            + "ORDER BY Population DESC "
                            + "LIMIT " + userVal;   //limit display
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);

            /* Report Name */
            System.out.println(GREEN + "Top populated countries by Region:" + RESET);

            /* Header in SQL style */
            System.out.printf("%-5s %-50s %-20s %-40s %-15s %-6s%n", "Code", "Country Name", "Continent", "Region", "Population", "Capital");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            /* Print data */
            while (rset.next()) {
                String countryCode = rset.getString("Code");
                String countryName = rset.getString("country_name");
                String conti = rset.getString("Continent");
                String regn = rset.getString("Region");
                int population = rset.getInt("Population");
                int countryCapital = rset.getInt("Capital");
                System.out.printf("%-5s %-50s %-20s %-40s %-15d %-6d%n", countryCode, countryName, conti, regn, population, countryCapital);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 6 ------------------------------

    //-------------- Method 8 - All Cities by Continent ------------------
    //-------------- John Chimezie --------------------
    public void citiesByContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS city_name, "
                            + "c.Name AS country_name, " //country name
                            + "ci.District, "
                            + "ci.Population "
                            + "FROM city ci "
                            + "JOIN country c ON ci.CountryCode = c.Code "
                            + "WHERE c.Continent = 'Asia' "   //Asia can be changed to another Continent
                            + "ORDER BY ci.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "All Cities by Continent:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-40s %-15s%n", "City Name", "Country", "District", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("city_name");
                String Country = rset.getString("country_name");
                String District = rset.getString("ci.District");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-40s %-15d%n", cityName, Country, District, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 8 ------------------------------

    //-------------- Method 15 - Top Populated Cities by Country ------------------
    //-------------- Bernard Daniel Young --------------------
    public void topPopCitiesByCountry()
    {
        int userVal = getNum(); // for N value
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS city_name, "
                            + "c.Name AS country_name, " //country name
                            + "ci.District, "
                            + "ci.Population "
                            + "FROM city ci "
                            + "JOIN country c ON ci.CountryCode = c.Code "
                            + "WHERE c.Name = 'United States' "   //United States can be changed to another Country
                            + "ORDER BY ci.Population DESC "
                            + "LIMIT " + userVal;    //limit display
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "Top Populated Cities by Country:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-40s %-15s%n", "City Name", "Country", "District", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("city_name");
                String Country = rset.getString("country_name");
                String District = rset.getString("ci.District");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-40s %-15d%n", cityName, Country, District, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 15 ------------------------------

    //-------------- Method 16 - Top Populated Cities by District ------------------
    //-------------- Bernard Daniel Young --------------------
    public void topPopCitiesByDistrict()
    {
        int userVal = getNum(); // for N value
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS city_name, "
                            + "c.Name AS country_name, " //country name
                            + "ci.District, "
                            + "ci.Population "
                            + "FROM city ci "
                            + "JOIN country c ON ci.CountryCode = c.Code "
                            + "WHERE ci.District = 'Kabol' "   //Kabol can be changed
                            + "ORDER BY ci.Population DESC "
                            + "LIMIT " + userVal;    //limit display
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "Top Populated Cities by District:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-40s %-15s%n", "City Name", "Country", "District", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("city_name");
                String Country = rset.getString("country_name");
                String District = rset.getString("ci.District");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-40s %-15d%n", cityName, Country, District, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 16 ------------------------------

    //-------------- Method 17 - All Capital Cities in World ------------------
    //-------------- Bernard Daniel Young --------------------
    public void allCapCitiesWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS capital_city, "
                            + "c.Name AS country_name, "
                            + "ci.Population "
                            + "FROM country c "
                            + "JOIN city ci ON c.Capital = ci.ID "
                            + "ORDER BY ci.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "All Capital Cities in World:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-15s%n", "City Name", "Country", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("capital_city");
                String Country = rset.getString("country_name");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-15d%n", cityName, Country, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 17 ------------------------------

    //-------------- Method 18 - All Capital Cities by Continent ------------------
    //-------------- Bernard Daniel Young --------------------
    public void allCapCitiesByContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS capital_city, "
                            + "c.Name AS country_name, "
                            + "ci.Population "
                            + "FROM country c "
                            + "JOIN city ci ON c.Capital = ci.ID "
                            + "WHERE c.Continent = 'Asia' "   //Asia can be changed to another Continent
                            + "ORDER BY ci.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "All Capital Cities by Continent:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-15s%n", "City Name", "Country", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("capital_city");
                String Country = rset.getString("country_name");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-15d%n", cityName, Country, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 18 ------------------------------

    //-------------- Method 19 - All Capital Cities by Region ------------------
    //-------------- Bernard Daniel Young --------------------
    public void allCapCitiesByRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS capital_city, "
                            + "c.Name AS country_name, "
                            + "ci.Population "
                            + "FROM country c "
                            + "JOIN city ci ON c.Capital = ci.ID "
                            + "WHERE c.Region = 'Caribbean' "   //Caribbean can be changed
                            + "ORDER BY ci.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "All Capital Cities by Region:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-15s%n", "City Name", "Country", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("capital_city");
                String Country = rset.getString("country_name");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-15d%n", cityName, Country, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 19 ------------------------------

    //-------------- Method 21 - Top Populated capital Cities by Continent ------------------
    //-------------- Kenneth Ramirez --------------------
    public void topPopCapitalCitiesByContinent()
    {
        int userVal = getNum(); // for N value
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    //SQL query
                    "SELECT ci.Name AS capital_city, "
                            + "c.Name AS country_name, "
                            + "ci.Population "
                            + "FROM country c "
                            + "JOIN city ci ON c.Capital = ci.ID "
                            + "WHERE c.Continent = 'Asia' "   //Asia can be changed to another Continent
                            + "ORDER BY ci.Population DESC "
                            + "LIMIT " + userVal;    //limit N display
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Report Name
            System.out.println(GREEN + "Top Populated Capital Cities by Continent:" + RESET);

            // Header in SQL style
            System.out.printf("%-50s %-50s %-15s%n", "City Name", "Country", "Population");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");    //add - depending on the values of the spacing

            //Print data
            while (rset.next()) {
                String cityName = rset.getString("capital_city");
                String Country = rset.getString("country_name");
                int population = rset.getInt("ci.Population");
                System.out.printf("%-50s %-50s %-15d%n", cityName, Country, population);
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Method 21 ------------------------------



    //-------------------------Connect to DB----------------------------
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
            System.out.println(BLUE + "Connecting to database..." + RESET);
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database world in world-db
                con = DriverManager.getConnection("jdbc:mysql://world-db:3306/world?useSSL=false", "root", "p@sswdr00t");
                //conn = con;
                System.out.println(BLUE + "Successfully connected" + RESET);
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println(RED + "Failed to connect to database attempt " + Integer.toString(i) + RESET);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println(RED + "Thread interrupted? Should not happen." + RESET);
            }
        }

    }
    //--------------------END Connect to DB------------------------

    //-------------- Test DB ------------------
    //-------------- Angel Ochoa --------------------
    public void showWorldDBTables()
    {
        try
        {
            /* Create an SQL statement */
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    /* SQL query */
                    "SHOW TABLES";
            /* Execute SQL statement */
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println(GREEN + "Tables for World DB:" + RESET);
            while (rset.next()) {
                System.out.println(rset.getString(1));
            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------ END Test DB ------------------------------

    //-----------------Disconnect from DB-------------------------
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
                System.out.println(RED + "Error closing connection to database" + RESET);
            }
        }
    }
    //-------------------END Disconnect from DB---------------------------
//}

    //-----------User input for N--------------
    public static int getNum()
    {
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        Scanner userEnt = new Scanner(System.in);
        int numEnt = -1;

        while (true) {
            try {
                System.out.print(GREEN + "Enter # of rows to display:" + RESET);
                numEnt = userEnt.nextInt();
                if (numEnt < 0) {
                    System.out.println(RED + "Error: Enter a number starting from '1'." + RESET);
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(RED + "Error: Enter a number starting from '1'." + RESET);
                userEnt.nextLine();
            }
        }

        return numEnt;
    }
    // -----------END input for N
}
