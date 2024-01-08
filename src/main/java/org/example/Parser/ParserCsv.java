package org.example.Parser;

import com.opencsv.bean.CsvToBeanBuilder;
import org.example.Parser.model.ForbesCsvModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserCsv {
    public static ArrayList<ForbesCsvModel> parser(String path) {
        try (FileReader fileReader = new FileReader(path)) {
            ArrayList<ForbesCsvModel> all = new ArrayList<>();
            List<ForbesCsvModel> beans = new CsvToBeanBuilder(fileReader)
                    .withType(ForbesCsvModel.class)
                    .build()
                    .parse();
            all.addAll(beans);
            return all;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
