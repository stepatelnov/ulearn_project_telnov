package org.example.converting;

public class ForbesModelDataBase {
    private Integer id;
    private Integer rank;
    private String name;
    private Double networth;
    private Integer age;
    private Integer country_id;
    private String source;
    private String industry;

    public ForbesModelDataBase(Integer rank, String name, Double networth, Integer age,
                               Integer country_id, String source, String industry) {
        this.rank = rank;
        this.name = name;
        this.networth = networth;
        this.age = age;
        this.country_id = country_id;
        this.source = source;
        this.industry = industry;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public Double getNetworth() {
        return networth;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public String getSource() {
        return source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetworth(Double networth) {
        this.networth = networth;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}

