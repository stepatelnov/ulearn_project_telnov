package org.example.service.impl;

import org.example.dao.abstracts.ReadDatabaseDao;
import org.example.dao.impl.ReadDatabaseDaoImpl;
import org.example.service.abstracts.ReadDatabaseService;

import java.util.Map;

public class ReadDatabaseServiceImpl implements ReadDatabaseService {
    ReadDatabaseDao readDatabaseDao = new ReadDatabaseDaoImpl();

    @Override
    public Map<String, Double> getTheFirstTask() {
        return readDatabaseDao.getTheFirstTask();
    }

    @Override
    public String getTheSecondTask() {
        return readDatabaseDao.getTheSecondTask();
    }

    @Override
    public String getTheThirdTask() {
        return readDatabaseDao.getTheThirdTask();
    }
}
