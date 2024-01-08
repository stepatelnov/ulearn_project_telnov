package org.example.converting;

import org.example.Parser.ParserCsv;
import org.example.Parser.model.ForbesCsvModel;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converting {
    private Map<String, CountryModelDataBase> countryMap = new HashMap<>();

    private List<ForbesModelDataBase> forbesModelDataBases = new ArrayList<>();

    private static final List<ForbesCsvModel> forbesCsvModels = ParserCsv.parser(Util.PATH);

    public Converting() {
        csvToForbesConvertingToCountry();
        csvToForbesDbConverting();
    }

    private void csvToForbesConvertingToCountry() {
        List<CountryModelDataBase> countryModelDataBases = new ArrayList<>();
        forbesCsvModels.forEach(forbesCsvModel -> {
            countryModelDataBases.add(new CountryModelDataBase(forbesCsvModel.getCountry().trim()));
        });
        if (countryModelDataBases != null) {
            List<CountryModelDataBase> distinctCountry =
                    countryModelDataBases.stream().distinct().collect(Collectors.toList());
            for (int i = 0; i < distinctCountry.size(); i++) {
                countryMap.put(distinctCountry.get(i).getCountryName(), new CountryModelDataBase(i + 1, distinctCountry.get(i).getCountryName()));
            }
        }
    }

    private void csvToForbesDbConverting() {
        forbesCsvModels.forEach(forbesCsvModel -> {
            forbesModelDataBases.add(new ForbesModelDataBase(Integer.parseInt(forbesCsvModel.getRank().trim()),
                    forbesCsvModel.getName(),
                    Double.parseDouble(forbesCsvModel.getNetworth().trim()),
                    Integer.parseInt(forbesCsvModel.getAge().trim()),
                    this.countryMap.get(forbesCsvModel.getCountry()).getId(),
                    forbesCsvModel.getSource(),
                    forbesCsvModel.getIndustry()
            ));
        });
    }

    public Map<String, CountryModelDataBase> getCountryMap() {
        return countryMap;
    }

    public List<ForbesModelDataBase> getForbesModelDataBases() {
        return forbesModelDataBases;
    }
}
