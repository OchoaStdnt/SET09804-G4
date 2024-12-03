/**
 *  This the main java file for running application to load reports from a database.
 *  The database used for this application is World DB.
 *  The main page will load a Menu with the several reports available to generate from the World DB
 *  NOTE: Use "docker-compose run app" to get the interactive menu
 */

package com.napier.devops;

public class App {
    public static void main(String[] args) {

        App a = new App();

        /* New instance for Menu class */
        Menu m = new Menu();

        //Lab 7 test NOT working
        //Methods me = new Methods();
        //me.connectToDatabase(args);

        /* Load Menu from Menu.java */
        m.menu();
    }
}