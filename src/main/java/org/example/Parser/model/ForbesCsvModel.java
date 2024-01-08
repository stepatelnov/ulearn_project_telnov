package org.example.Parser.model;

import com.opencsv.bean.CsvBindByName;

public class ForbesCsvModel {
    @CsvBindByName(column = "Rank")
    private String rank;
    @CsvBindByName(column = "Name")
    private String name;
    @CsvBindByName(column = "Networth")
    private String networth;
    @CsvBindByName(column = "Age")
    private String age;
    @CsvBindByName(column = "Country")
    private String country;
    @CsvBindByName(column = "Source")
    private String source;
    @CsvBindByName(column = "Industry")
    private String Industry;
    public String getRank() {
        return rank;
    }
    public String getName() {
        return name;
    }
    public String getNetworth() {
        return networth;
    }
    public String getAge() {
        return age;
    }
    public String getCountry() {
        return country;
    }
    public String getSource() {
        return source;
    }
    public String getIndustry() {
        return Industry;
    }
}
