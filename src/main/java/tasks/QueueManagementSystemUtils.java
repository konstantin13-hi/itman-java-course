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
        double result = calcTotalVisits(systems)/systems.length;
        return result;
    }

}
