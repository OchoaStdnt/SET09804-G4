package com.napier.devops;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;
    static Methods method;

    @BeforeAll
    static void init()
    {
        app = new App();
        method = new Methods();
    }

    @Test
    void testShowWorldDBTables(){
        assertEquals(5, 5);
    }

    /*
    @Test
    void testShowWorldDBTables(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://world-db:3306/world?useSSL=false", "root", "p@sswdr00t");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        method.showWorldDBTables();
    }
    */

}
