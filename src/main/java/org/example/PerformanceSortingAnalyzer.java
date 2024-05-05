
package org.example;

import java.util.*;

public class PerformanceSortingAnalyzer {

    public static final int WARMUP_ROUNDS = 10;
    public static final int SORT_ROUNDS =10;

    public static Map<String, Double> performanceSortingAnalyzer(BinomialDistributionRandomNumber binomialDistributionRNG){
        Map<String, Double> timeTables = new HashMap<>();
        for (int nk : binomialDistributionRNG.getDataSize()){
            warmupJVM(nk);
            for (int m : binomialDistributionRNG.getMeans()){
                for (double v : binomialDistributionRNG.getVariances()){
                    ArrayList<Double> data = binomialDistributionRNG.getData(m,v,nk);
                    //average case
                    long averageTime = 0;
                    for (int i=0;i<SORT_ROUNDS;i++){

                        ArrayList<Double> clonedList = new ArrayList<>(data);
                        averageTime += getElapsedTime(clonedList);
                    }

                    String key=BinomialDistributionRandomNumber.getKey(m,v,nk);
                    timeTables.put(key, (double)averageTime/SORT_ROUNDS);
                }
            }
        }
        return timeTables;
    }
    public static  Map<Integer, Double> resultToChart(Map<String, Double> results,int[] means,double[] variances,int[] dataSize){
        Map<Integer, Double> timeTables = new HashMap<>();
        for (int nk : dataSize){
            long averageTime=0;


            for (int m :means){
                for (double v :variances){
                    String key=BinomialDistributionRandomNumber.getKey(m,v,nk);
                    double time=results.get(key);
                    averageTime+=time;


                }
            }
            int n=means.length*variances.length;
            timeTables.put(nk,(double)averageTime/n);


        }
        return timeTables;

    }

    private static long getElapsedTime(ArrayList<Double> data) {
        long startTime = System.nanoTime();
        InsertionSort.sort(data);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }


    private static void warmupJVM(int dataSize) {
        for (int i = 0; i< WARMUP_ROUNDS; i++){
            ArrayList<Double> data = BinomialDistributionRandomNumber.generateData(dataSize);
            InsertionSort.sort(data);
        }
    }




}