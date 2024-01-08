package org.example.util;

import org.example.service.abstracts.MigrationToDatabaseService;
import org.example.service.impl.MigrationToDatabaseServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String URL = "jdbc:sqlite:identifier.sqlite";
    public static final String PATH = "Forbes.csv";


    public static Connection getConn() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createTable() {
        String createTableForbes = "create table forbes_table ('id' integer primary key, " +
                "country_id integer not null, " +
                "name varchar(255) not null," +
                "rank integer not null," +
                "networth real not null," +
                "age integer not null," +
                "source varchar(255) not null, " +
                "industry varchar(255) not null);";

        String createTableCountries = "create table countries_table " +
                "('id' integer, " +
                "country_name varchar(100));";
        try {
            Statement statement = getConn().createStatement();
            statement.execute(createTableForbes);
            statement.execute(createTableCountries);
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void populatingDatabase() {
        MigrationToDatabaseService migrationToDatabaseService = new MigrationToDatabaseServiceImpl();
        migrationToDatabaseService.migrationToCountry();
        migrationToDatabaseService.migrationToForbes();
    }
}
