package tasks;

import tasks.QueueManagementSystem;

public class QueueManagementSystemUtils {


    public static long calcTotalVisits(QueueManagementSystem[] systems) {
        long result = 0;
        for (int i = 0; i < systems.length; i++) {
            result = result + systems[i].getTotalTickets();
        }
        return result;
    }
    public static double calcAverageVisits(QueueManagementSystem[] systems){
        if (systems.length==0){
          return 0;
        }
        return (double)calcTotalVisits(systems)/systems.length;
    }
    public static double calcMedianVisits(QueueManagementSystem[] systems){
        if (systems.length==0){
            return 0;
        }
        double[] median =new double[systems.length];

        for (int i =0;i<median.length;i++){
            median[i]=systems[i].getTotalTickets();
        }
        for (int i=0;i<median.length;i++){
            for(int j=1;j<median.length;j++){
                if (median[j-1]>median[j]){
                    double temp =median[j-1];
                    median[j-1]=median[j];
                    median[j]=temp;
                }
            }

        }
        double result;
        if (systems.length % 2 == 0) {
            result = (median[(systems.length - 1) / 2] + median[((systems.length - 1) / 2) + 1]) / 2;
        } else {
            result = Math.round((double)calcTotalVisits(systems)/systems.length);
        }
        return result;
    }

}
