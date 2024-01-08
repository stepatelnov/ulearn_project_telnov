package org.example.dao.abstracts;

import java.util.Map;

public interface ReadDatabaseDao {

    String getTheSecondTask();

    String getTheThirdTask();

    Map<String, Double> getTheFirstTask();
}
