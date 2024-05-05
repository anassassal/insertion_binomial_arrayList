package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] means = {5, 8, 11, 15, 18}; // Example means
        double[] variances = {0.85, 1.7, 2.55,3.4,4.25}; // Example variances
        int[] dataSize = {300, 600, 900,1200,1500};
        BinomialDistributionRandomNumber distributionRNG = new BinomialDistributionRandomNumber(means,variances,dataSize);


        Map<String,Double> result =  PerformanceSortingAnalyzer.performanceSortingAnalyzer(distributionRNG);

        System.out.println(result);

        FileCSV.generateCSV(distributionRNG);

        Map<Integer, Double> resultToChart = new HashMap<>();
        resultToChart=PerformanceSortingAnalyzer.resultToChart(result,means,variances,dataSize);


        ChartGenerator.displayChart(resultToChart,dataSize);
//        System.out.println(resultToChart);
        ViewResults.show(result,means,variances,dataSize);

    }





}
