package org.example.dao.impl;

import org.example.dao.abstracts.ReadDatabaseDao;
import org.example.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ReadDatabaseDaoImpl implements ReadDatabaseDao {

    @Override
    public Map<String, Double> getTheFirstTask() {
        Map<String, Double> resultMap = new HashMap<>();
        try (ResultSet resultSet = Util.getConn().prepareStatement("SELECT country_name, sum(networth) as 'networth' from countries_table ct " +
                "INNER JOIN forbes_table ft on ft.country_id = ct.id GROUP BY ct.country_name;").executeQuery()) {
            while (resultSet.next()) {
                resultMap.put(resultSet.getString("country_name"), resultSet.getDouble("networth"));
            }
            return resultMap;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTheSecondTask() {
        try (ResultSet resultSet = Util.getConn().prepareStatement("SELECT ct.country_name, ft.name as 'name', min(ft.age), " +
                "ft.networth from forbes_table ft INNER JOIN countries_table ct " +
                "on ft.country_id = ct.id WHERE country_name = 'France' and networth > 10.0;").executeQuery()) {
            String res = "The youngest billionaire from France, whose capital exceeds 10 billion : ";
            String name = resultSet.getString("name");
            return res + name;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTheThirdTask() {
        try (ResultSet resultSet = Util.getConn().prepareStatement("SELECT ct.country_name, ft.name, max(ft.networth), ft.source, ft.industry from forbes_table ft " +
                "INNER JOIN countries_table ct " +
                "on ft.country_id = ct.id " +
                "WHERE country_name = 'United States' and industry = 'Energy ';").executeQuery()) {
            return "The name and company of a US businessman with the largest capital in the Energy sector : "
                    + resultSet.getString("name") + ", " + resultSet.getString("source");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
