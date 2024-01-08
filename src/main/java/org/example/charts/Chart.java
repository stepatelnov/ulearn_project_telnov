package org.example.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Map;

public class Chart {

    public static void getChart(Map<String, Double> map) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (var i : map.entrySet()) {
            dataset.setValue(i.getValue(), "Страны", i.getKey());
        }
        JFreeChart chart = ChartFactory.createBarChart("Общие капиталы участников Forbes разделенные по странам", "Страны", "Общие капиталы участников Forbes разделенные по странам", dataset);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setNumberFormatOverride(NumberFormat.getNumberInstance());

        CategoryLabelPositions positions = CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0);
        domainAxis.setCategoryLabelPositions(positions);

        try {
            ChartUtils.saveChartAsPNG(new File("Chart.png"), chart, 1500, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
