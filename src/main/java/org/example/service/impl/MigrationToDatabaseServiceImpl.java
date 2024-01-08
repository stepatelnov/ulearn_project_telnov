package org.example.service.impl;

import org.example.dao.abstracts.MigrationToDatabaseDAO;
import org.example.dao.impl.MigrationToDatabaseDAOImpl;
import org.example.service.abstracts.MigrationToDatabaseService;

public class MigrationToDatabaseServiceImpl implements MigrationToDatabaseService {
    MigrationToDatabaseDAO migrationToDatabaseDAO = new MigrationToDatabaseDAOImpl();
    @Override
    public void migrationToForbes() {
        migrationToDatabaseDAO.migrationToForbes();
    }

    @Override
    public void migrationToCountry() {
        migrationToDatabaseDAO.migrationToCountry();
    }

}
