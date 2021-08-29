package tasks;

import entities.Statistic;
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

    public static long[] calcC(QueueManagementSystem[] systems) {
        long []arrayDays = new long [sizeForLength(systems)];
        for (int i = 0, h=0; i < arrayDays.length; i++) {
            for (int j = 0, h1 = h; j < arrayDays.length; j++) {
                if(systems[j].getVisitsByDay().size()>=arrayDays.length-h){
                    arrayDays[i]+=systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDays.length);
                }
            }
            h++;
        }

        return arrayDays;
    }

    public static int sizeForLength(QueueManagementSystem[] systems){
        int max = 0;
        for (QueueManagementSystem system : systems) {
            if (max < system.getVisitsByDay().size()) {
                max = system.getVisitsByDay().size();
            }

        }
        return max;
    }

    public static double[] getAverage(QueueManagementSystem[] systems){
        long []arrayAllTickets =calcC(systems);
        int[]arrayDays = new int[sizeForLength(systems)];
        double[]array = new double[sizeForLength(systems)];
        for (int i = 0, h=0; i < arrayDays.length; i++) {
            for (int j = 0; j < arrayDays.length; j++) {
                if(systems[j].getVisitsByDay().size()>=arrayDays.length-h){
                    arrayDays[i]+=1;
                }
            }
            h++;
            array[i]=(double) arrayAllTickets[i]/arrayDays[i];
        }


        return array;
    }

    public static int[] getMin(QueueManagementSystem[]systems){
        int[]arrayDaysMin = new int[sizeForLength(systems)];
        int min = Integer.MAX_VALUE;
        for (int i = 0, h=0; i < arrayDaysMin.length; i++) {
            for (int j = 0; j < arrayDaysMin.length; j++) {
                if(systems[j].getVisitsByDay().size()>=arrayDaysMin.length-h){
                    if(min>systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDaysMin.length)){
                        min=systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDaysMin.length);
                    arrayDaysMin[i]=systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDaysMin.length);}
                }
            }
            h++;
            min= Integer.MAX_VALUE;
        }
        return arrayDaysMin;
    }

    public static int[] getMax(QueueManagementSystem[]systems){
        int[]arrayDaysMin = new int[sizeForLength(systems)];
        int max = Integer.MIN_VALUE;
        for (int i = 0, h=0; i < arrayDaysMin.length; i++) {
            for (int j = 0; j < arrayDaysMin.length; j++) {
                if(systems[j].getVisitsByDay().size()>=arrayDaysMin.length-h){
                    if(max<systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDaysMin.length)){
                        max=systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDaysMin.length);
                        arrayDaysMin[i]=systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDaysMin.length);}
                }
            }
            h++;
            max= Integer.MIN_VALUE;
        }
        return arrayDaysMin;
    }

    public static int[] getAmount(QueueManagementSystem[] systems){
        int[]arrayDays = new int[sizeForLength(systems)];
        for (int i = 0, h=0; i < arrayDays.length; i++) {
            for (int j = 0; j < arrayDays.length; j++) {
                if(systems[j].getVisitsByDay().size()>=arrayDays.length-h){
                    arrayDays[i]+=1;
                }
            }
            h++;
        }
        return arrayDays;
    }

    public static double sortTickets(int[]array){
        double result;
        int [] median =array;
        for (int i=0;i<median.length;i++){
            for(int j=1;j<median.length;j++){
                if (median[j-1]>median[j]){
                    int temp =median[j-1];
                    median[j-1]=median[j];
                    median[j]=temp;
                }
            }

        }
        if (array.length % 2 == 0) {
            result = ((double)median[(array.length - 1) / 2] + median[((array.length - 1) / 2) + 1]) / 2;
        } else {
            result = median[(array.length - 1) / 2];
        }


        return result;
    }

    public static double[] getMedian(QueueManagementSystem[] systems){
        int[]arrayAllTickets =getAmount(systems);
        double[]arrayDays = new double[sizeForLength(systems)];
        int [] arrayForMedian;
        for (int i = 0, h=0; i < arrayDays.length; i++) {
            arrayForMedian = new int[arrayAllTickets[i]];
            for (int j = 0; j < arrayDays.length; j++) {
                if(systems[j].getVisitsByDay().size()>=arrayDays.length-h){
                    arrayForMedian[systems[j].getVisitsByDay().size()+i-arrayDays.length]+=systems[j].getVisitsByDay().get(systems[j].getVisitsByDay().size()+i-arrayDays.length);
                }
            }
            arrayDays[i]=sortTickets(arrayForMedian);
            h++;

        }
        return arrayDays;
    }

    public Statistic[] calcStatisticByDays(QueueManagementSystem[] systems){

        int []arrayDays = new int [sizeForLength(systems)];


        Statistic[] calcStatisticByDays=new Statistic[sizeForLength(systems)];
        for (int i=0;i<systems.length;i++){
            calcStatisticByDays[i].setAverage(getAverage(systems)[i]);
            calcStatisticByDays[i].setCount(calcC(systems)[i]);
            calcStatisticByDays[i].setMedian(getMedian(systems)[i]);
            calcStatisticByDays[i].setMin(getMin(systems)[i]);
            calcStatisticByDays[i].setMax(getMax(systems)[i]);
        }

        return calcStatisticByDays;
    }

}
