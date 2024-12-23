/**
 *  This file contains the Menu that will load once App.java starts up.
 *  The menu contains the several Options to Run the reports. A total of 32 Options are available to run.
 *  The two extra Options "0" and "1234" are for Exiting the Application and testing connection to the DB respectively
 *  Colors were added to the Headings of the Menu and the reports as well as when the App connects to the DB and Exits the Application.
 *  This was done for better readability of the running app in a Terminal
 */
package com.napier.devops;
import java.util.Scanner;

public class Menu {
    /* New instance for Menu class */
    Methods m = new Methods();

    public void menu()
    {
        /* Connect to DB */
        m.connect();

        /* LAB 7 test not working */
        // m.connectToDatabase(args);

        /* add colors to the system out */
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String RED = "\u001B[31m";
        final String YELLOW = "\u001B[33m";

        /* to accept user choices */
        Scanner userInput = new Scanner(System.in);
        int userChoice; //to save the option by the user

        do {
            /* Menu */
            System.out.println();   //Blank line
            System.out.println(GREEN + "***********************************************************************************" + RESET);   //start of menu.
            System.out.println(GREEN + "* Enter the # of the Report you want to run and press 'Enter':                    *" + RESET);   //start of menu.
            System.out.println(GREEN + "* Note all reports are displayed in order of population from largest to smallest. *" + RESET);   //start of menu.
            System.out.println(GREEN + "***********************************************************************************" + RESET);   //start of menu.

            /* Menu Options */
            System.out.println("1. All Countries in World from largest to smallest");   //Added by Angel Ochoa COMPLETED
            System.out.println("2. All Countries by Continent (Asia) from largest to smallest");  //Added by Donisio Rash COMPLETED
            System.out.println("3. All Countries by Region (Caribbean) from largest to smallest");  //Added by Donisio Rash

            System.out.println("4. Top Populated Countries in World from largest to smallest");  //Added by Donisio Rash
            System.out.println("5. Top Populated Countries by Continent (Asia) from largest to smallest");  //Added by Donisio Rash
            System.out.println("6. Top Populated Countries by Region (Caribbean) from largest to smallest");  //Added by Donisio Rash

            System.out.println("7. All Cities in World from largest to smallest");    //Added by Angel Ochoa
            System.out.println("8. All Cities by Continent (Asia) from largest to smallest");    //Added by John Chimezie COMPLETED
            System.out.println("9. All Cities by Region (Caribbean) from largest to smallest");    //Added by John Chimezie
            System.out.println("10. All Cities by Country (United States) from largest to smallest");    //Added by John Chimezie
            System.out.println("11. All Cities by District (Kabol) from largest to smallest");    //Added by John Chimezie

            System.out.println("12. Top Populated Cities in World from largest to smallest");    //Added by John Chimezie
            System.out.println("13. Top Populated Cities by Continent (Asia) from largest to smallest");    //Added by Angel Ochoa
            System.out.println("14. Top Populated Cities by Region (Caribbean) from largest to smallest");    //Added by Angel Ochoa
            System.out.println("15. Top Populated Cities by Country (United States) from largest to smallest");  //Added by Bernard Young COMPLETED

            System.out.println("16. Top Populated Cities by District (Kabol) from largest to smallest");  //Added by Bernard Young

            System.out.println("17. All Capital Cities in World from largest to smallest");  //Added by Bernard Young
            System.out.println("18. All Capital Cities by Continent (Asia) from largest to smallest");  //Added by Bernard Young
            System.out.println("19. All Capital Cities by Region (Caribbean) from largest to smallest");  //Added by Bernard Young

            System.out.println("20. Top Populated Capital Cities by World from largest to smallest");  //Added by Angel Ochoa
            System.out.println("21. Top Populated Capital Cities by Continent (Asia) from largest to smallest");  //Added by Kenneth Ramirez COMPLETED
            System.out.println("22. Top Populated Capital Cities by Region (Southeast Asia) from largest to smallest");  //Added by Kenneth Ramirez

            System.out.println("23. The population of people, people in Cities, and people not living in cities by each Continent");  //Added by Kenneth Ramirez
            System.out.println("24. The population of people, people in Cities, and people not living in cities by each Region");  //Added by Kenneth Ramirez
            System.out.println("25. The population of people, people in Cities, and people not living in cities by each Country");  //Added by Kenneth Ramirez

            System.out.println("23. The population of people, people in Cities, and people not living in cities by each Continent");  //Added by Kenneth Ramirez
            System.out.println("24. The population of people, people in Cities, and people not living in cities by each Region");  //Added by Kenneth Ramirez
            System.out.println("25. The population of people, people in Cities, and people not living in cities by each Country");  //Added by Kenneth Ramirez

            System.out.println("26. The population of the World");  //Added by Angel Ochoa
            System.out.println("27. The population of a Continent (Asia)");  //Added by Angel Ochoa
            System.out.println("28. The population of a Region (Western Europe)");  //Added by Angel Ochoa
            System.out.println("29. The population of a Country (France)");  //Added by Angel Ochoa
            System.out.println("30. The population of a District (California)");  //Added by Angel Ochoa
            System.out.println("31. The population of a City (Tokyo)");  //Added by Angel Ochoa

            System.out.println("32. The population that speak Chinese, English, Hindi, Spanish, and Arabic");  //Added by Angel Ochoa

            /* Exit Menu/Application */
            System.out.println("0. Exit");  //Added by Angel Ochoa

            /* Test DB */
            System.out.println(YELLOW + "1234. TEST DATABASE (Show Tables on World DB)" + RESET);   //Added by Angel Ochoa

            userChoice = userInput.nextInt();   //Read user input
            userInput.nextLine();   //Save the user input
            //--------------------------------------------------------------
            System.out.println();   //Blank line

            switch (userChoice) {
                /* Reports */
                case 1: //Angel Ochoa
                    m.allCountriesByPop();
                    break;
                case 2: //Donisio Rash
                    m.countriesByContinent();
                    break;
                case 3: //Donisio Rash
                    m.countriesByRegion();
                    break;

                case 4: //Donisio Rash
                    m.topPopCountriesInWorld();
                    break;
                case 5: //Donisio Rash
                    m.topPopCountriesByContinent();
                    break;
                case 6: //Donisio Rash
                    m.topPopCountriesByRegion();
                    break;

                case 7: //Angel Ochoa
                    m.citiesByWorld();
                    break;
                case 8: //John Chimezie
                    m.citiesByContinent();
                    break;
                case 9: //John Chimezie
                    m.citiesByRegion();
                    break;
                case 10: //John Chimezie
                    m.citiesByCountry();
                    break;
                case 11: //John Chimezie
                    m.citiesByDistrict();
                    break;

                case 12: //John Chimezie
                    m.topPopCitiesInWorld();
                    break;
                case 13: //Angel Ochoa
                    m.topPopCitiesbyContinent();
                    break;
                case 14: //Angel Ochoa
                    m.topPopCitiesbyRegion();
                    break;
                case 15: //Bernard Young
                    m.topPopCitiesByCountry();
                    break;

                case 16: //Bernard Young
                    m.topPopCitiesByDistrict();
                    break;

                case 17: //Bernard Young
                    m.allCapCitiesWorld();
                    break;
                case 18: //Bernard Young
                    m.allCapCitiesByContinent();
                    break;
                case 19: //Bernard Young
                    m.allCapCitiesByRegion();
                    break;

                case 20: //Angel Ochoa
                    m.topPopCapitalCitiesWorld();
                    break;
                case 21: //Kenneth Ramirez
                    m.topPopCapitalCitiesByContinent();
                    break;
                case 22: //Kenneth Ramirez
                    m.topPopCapitalCitiesByRegion();
                    break;

                case 23: //Kenneth Ramirez
                    m.popOfPplPplCitiesPplNotCityByContinent();
                    break;
                case 24: //Kenneth Ramirez
                    m.popOfPplPplCitiesPplNotCityByRegion();
                    break;
                case 25: //Kenneth Ramirez
                    m.popOfPplPplCitiesPplNotCityByCountry();
                    break;

                case 26: //Angel Ochoa
                    m.popOfWorld();
                    break;
                case 27: //Angel Ochoa
                    m.popOfContinent();
                    break;
                case 28: //Angel Ochoa
                    m.popOfRegion();
                    break;
                case 29: //Angel Ochoa
                    m.popOfCountry();
                    break;
                case 30: //Angel Ochoa
                    m.popOfDistrict();
                    break;
                case 31: //Angel Ochoa
                    m.popOfCity();
                    break;

                case 32: //Angel Ochoa
                    m.popOfLang();
                    break;

                /* exit */
                case 0:
                    System.out.println(RED + "Exiting..." + RESET);
                    m.disconnect();
                    break;

                /* Test DB */
                case 1234:
                    m.showWorldDBTables();
                    break;

                default:
                    System.out.println("Invalid entry, try again.");
            }
        } while (userChoice != 0);
        userInput.close();
    }
}
