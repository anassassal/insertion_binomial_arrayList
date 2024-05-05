package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;

public class ChartGenerator {

    public static void displayChart(Map<Integer, Double> data, int []dataSizes) {
        // Create a dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int dataSize : dataSizes) {
            double time = data.get(dataSize);
            time=time/1_000_000.0;
            dataset.addValue(time, "Average Time", (Integer)dataSize);
        }

        // Create the chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Sorting Execution Times", // Chart title
                "Data Size",               // Domain axis label
                "Time (ms)",               // Range axis label (changed to milliseconds)
                dataset,                   // Dataset
                PlotOrientation.VERTICAL,  // Orientation
                true,                      // Include legend
                true,                      // Tooltips
                false);                    // URLs

        // Adjust the range axis to display milliseconds or seconds
        NumberAxis rangeAxis = (NumberAxis) barChart.getCategoryPlot().getRangeAxis();
        rangeAxis.setAutoRangeIncludesZero(false); // Ensure zero is not included in the range
        rangeAxis.setNumberFormatOverride(new java.text.DecimalFormat("#.##")); // Format axis labels

        // Display the chart
        JFrame frame = new JFrame();
        frame.setContentPane(new ChartPanel(barChart));
        frame.setTitle("Execution Time Benchmark");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}