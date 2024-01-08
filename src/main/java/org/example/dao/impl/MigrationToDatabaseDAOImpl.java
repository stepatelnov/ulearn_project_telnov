package org.example.dao.impl;

import org.example.converting.Converting;
import org.example.converting.CountryModelDataBase;
import org.example.converting.ForbesModelDataBase;
import org.example.dao.abstracts.MigrationToDatabaseDAO;
import org.example.util.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class MigrationToDatabaseDAOImpl implements MigrationToDatabaseDAO {
    private final Converting converting = new Converting();
    @Override
    public void migrationToForbes() {
        List<ForbesModelDataBase> forbesModelDataBaseList = converting.getForbesModelDataBases();
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `forbes_table` (`country_id`, " +
                "`name`, `rank`, `networth`, `age`, `source`, `industry`) VALUES\n" +
                " (?,?,?,?,?,?,?);")) {
            for (ForbesModelDataBase forbes : forbesModelDataBaseList) {
                preparedStatement.setInt(1, forbes.getCountry_id());
                preparedStatement.setString(2, forbes.getName());
                preparedStatement.setInt(3, forbes.getRank());
                preparedStatement.setDouble(4, forbes.getNetworth());
                preparedStatement.setInt(5, forbes.getAge());
                preparedStatement.setString(6, forbes.getSource());
                preparedStatement.setString(7, forbes.getIndustry());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void migrationToCountry() {
        List<CountryModelDataBase> countryList = converting.getCountryMap().values().stream().collect(Collectors.toList());
        try (PreparedStatement preparedStatement = Util.getConn().prepareStatement("INSERT INTO `countries_table` (`id`, `country_name`) VALUES\n" +
                " (?,?);")) {
            for (CountryModelDataBase country : countryList) {
                preparedStatement.setInt(1, country.getId());
                preparedStatement.setString(2, country.getCountryName());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
