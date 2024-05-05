package org.example;

import java.util.Map;

public class ViewResults {
    public static void show(Map<String,Double> results,int[] means,double[] variances,int[] dataSize){
        for (int nk:dataSize){
            System.out.println("------------------------------------------------------------------------------ nk="+nk+" ------------------------------------------------------------------------------ ");
            for (int m:means){
                for (double v:variances){
                    String key =getKey(m,v,nk);
                    double time=results.get(key);
                    System.out.print(key+" "+time/1000000+"ms]\t");

                }
                System.out.println();
            }
        }
    }
    public static String getKey(int mean, double variance, int dataSize) {
        return "mean_" + mean + "_variance_" + variance + "_datasize_" + dataSize;
    }
}
