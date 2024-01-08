package org.example.converting;

import java.util.Objects;

public class CountryModelDataBase {
    private Integer id;

    private String countryName;

    public CountryModelDataBase(Integer id, String countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public CountryModelDataBase() {
    }

    public CountryModelDataBase(String countryName) {
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryModelDataBase that = (CountryModelDataBase) o;
        return Objects.equals(id, that.id) && Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName);
    }
}
