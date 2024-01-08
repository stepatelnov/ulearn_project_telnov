package org.example;

import org.example.charts.Chart;
import org.example.service.abstracts.ReadDatabaseService;
import org.example.service.impl.ReadDatabaseServiceImpl;
import org.example.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.createTable();
        Util.populatingDatabase();
        ReadDatabaseService readDatabaseService = new ReadDatabaseServiceImpl();
        Chart.getChart(readDatabaseService.getTheFirstTask());
        System.out.println("---------------------------------");
        System.out.println(readDatabaseService.getTheSecondTask());
        System.out.println("---------------------------------");
        System.out.println(readDatabaseService.getTheThirdTask());

    }
}