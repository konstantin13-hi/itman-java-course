package tasks;

import entities.Statistic;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueManagementSystemUtilsTest {


    @Test
    public void countQueue(){
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0]= new QueueManagementSystem("Bank");
        Ticket b =systems[0].getNextTicket();
        Ticket b1 =systems[0].getNextTicket();
        Ticket b2 =systems[0].getNextTicket();
        systems[1]= new QueueManagementSystem("Bank2");
        Ticket b3 =systems[1].getNextTicket();
        Ticket b4 =systems[1].getNextTicket();
        Ticket b5 =systems[1].getNextTicket();
        systems[2]= new QueueManagementSystem("Bank3");
        Ticket b6 =systems[2].getNextTicket();
        Ticket b7 =systems[2].getNextTicket();

        Assertions.assertEquals(8,QueueManagementSystemUtils.calcTotalVisits(systems));

    }
    @Test
    public void calcAverageVisits(){
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0]= new QueueManagementSystem("Bank");
        Ticket b =systems[0].getNextTicket();
        Ticket b1 =systems[0].getNextTicket();
        Ticket b2 =systems[0].getNextTicket();
        systems[1]= new QueueManagementSystem("Bank2");
        Ticket b3 =systems[1].getNextTicket();
        Ticket b4 =systems[1].getNextTicket();
        Ticket b5 =systems[1].getNextTicket();
        Assertions.assertEquals(3,QueueManagementSystemUtils.calcAverageVisits(systems));

    }

    @Test
    public void calcAverage(){
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0]= new QueueManagementSystem("Bank");
        Ticket b =systems[0].getNextTicket();
        systems[1]= new QueueManagementSystem("Bank2");
        Ticket b3 =systems[1].getNextTicket();
        Ticket b4 =systems[1].getNextTicket();
        Ticket b5 =systems[1].getNextTicket();
        Ticket b6 =systems[1].getNextTicket();
        systems[2]= new QueueManagementSystem("Bank3");
        Ticket b7 =systems[2].getNextTicket();
        Ticket b8 =systems[2].getNextTicket();
        Assertions.assertEquals(7.0/3,QueueManagementSystemUtils.calcAverageVisits(systems));

    }

    @Test
    public void calc(){
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0]= new QueueManagementSystem("Bank");
        Ticket b =systems[0].getNextTicket();
        systems[1]= new QueueManagementSystem("Bank2");
        Ticket b3 =systems[1].getNextTicket();
        Ticket b4 =systems[1].getNextTicket();
        Ticket b5 =systems[1].getNextTicket();
        Ticket b6 =systems[1].getNextTicket();
        systems[2]= new QueueManagementSystem("Bank3");
        Ticket b7 =systems[2].getNextTicket();
        Ticket b8 =systems[2].getNextTicket();
        Assertions.assertEquals(2.0,QueueManagementSystemUtils.calcMedianVisits(systems));

    }

    @Test
    public void calcSecond(){
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0]= new QueueManagementSystem("Bank");
        Ticket b =systems[0].getNextTicket();
        systems[1]= new QueueManagementSystem("Bank2");
        Ticket b3 =systems[1].getNextTicket();
        Ticket b4 =systems[1].getNextTicket();
        systems[2]= new QueueManagementSystem("Bank3");
        Ticket b7 =systems[2].getNextTicket();
        Ticket b8 =systems[2].getNextTicket();
        Ticket b9 =systems[2].getNextTicket();
        systems[3]= new QueueManagementSystem("Bank3");
        Ticket b10 =systems[3].getNextTicket();
        Ticket b11 =systems[3].getNextTicket();
        Ticket b12 =systems[3].getNextTicket();
        Ticket b13 =systems[3].getNextTicket();
        Assertions.assertEquals(2.5,QueueManagementSystemUtils.calcMedianVisits(systems));


    }

    @Test
    public void calcTest() {
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0] = new QueueManagementSystem("Bank");
        systems[0].getNextTicket();//4 t
        systems[0].toNextWorkDay();
        systems[0].getNextTicket();
        systems[0].toNextWorkDay();
        systems[0].getNextTicket();
        systems[0].toNextWorkDay();
        systems[0].getNextTicket();
        systems[1] = new QueueManagementSystem("Bank2");
        systems[1].getNextTicket();//2
        systems[1].toNextWorkDay();
        systems[1].getNextTicket();
        systems[2] = new QueueManagementSystem("Bank3");
        systems[2].getNextTicket();//3
        systems[2].toNextWorkDay();
        systems[2].getNextTicket();      // 4 2 3 1// 1 2 3 4//
        systems[2].toNextWorkDay();
        systems[2].getNextTicket();
        systems[3] = new QueueManagementSystem("Bank3");
        systems[3].getNextTicket();
        int[]min=new int[]{1,1,1,1};
        int[]max=new int[]{1,1,1,1};
        double[]average=new double[]{1,1,1,1};
        long[]count=new long[]{1,2,3,4};
        double[]median=new double[]{1,1,1,1};
        test(systems,min,max,average,count,median);
    }

    @Test
    public void calcTestSecond() {
        int y =10;
        int y1 = 20;
        int y2 = 30;
        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0],y);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y1);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1],y2);
        int[]min=new int[]{10,20};
        int[]max=new int[]{10,30};
        double[]average=new double[]{10,25};
        long[]count=new long[]{10,50};
        double[]median=new double[]{10,25};
        test(systems,min,max,average,count,median);
    }

    @Test
    public void calcTestThird() {
        int y =1;
        int y1 = 2;
        int y2 = 3;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0],y);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y1);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y2);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1],y);
        systems[1].toNextWorkDay();
        createTicket(systems[1],y1);
        systems[1].toNextWorkDay();
        createTicket(systems[1],y2);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2],y);
        systems[2].toNextWorkDay();
        createTicket(systems[2],y1);
        systems[2].toNextWorkDay();
        createTicket(systems[2],y2);
        int[]min=new int[]{1,2,3};
        int[]max=new int[]{1,2,3};
        double[]average=new double[]{1,2,3};
        long[]count=new long[]{3,6,9};
        double[]median=new double[]{1,2,3};
        test(systems,min,max,average,count,median);
    }

    @Test
    public void calcTestFourth() {
        int y =1;
        int y1 = 2;
        int y2 = 3;
        QueueManagementSystem[] systems = new QueueManagementSystem[1];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0],y);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y1);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y2);
        int[]min=new int[]{1,2,3};
        int[]max=new int[]{1,2,3};
        double[]average=new double[]{1,2,3};
        long[]count=new long[]{1,2,3};
        double[]median=new double[]{1,2,3};
        test(systems,min,max,average,count,median);

    }

    @Test
    public void calcTestFifth() {
        int y =1;
        int y1 = 2;
        int y2 = 3;
        int y3 = 4;
        int y4 = 5;
        int y5 = 7;
        int y6 = 10;
        QueueManagementSystem[] systems = new QueueManagementSystem[3];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0],y);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y1);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y2);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y3);
        systems[1] = new QueueManagementSystem("Bank2");
        systems[1].toNextWorkDay();
        createTicket(systems[1],y);
        systems[2] = new QueueManagementSystem("Bank3");
        createTicket(systems[2],y4);
        systems[2].toNextWorkDay();
        createTicket(systems[2],y6);
        systems[2].toNextWorkDay();
        createTicket(systems[2],y5);
        int[]min=new int[]{1,2,0,1};
        int[]max=new int[]{1,5,10,7};
        double[]average=new double[]{1,3.5,(double)13/3,4};
        long[]count=new long[]{1,7,13,12};
        double[]median=new double[]{1,3.5,3,4};
        test(systems,min,max,average,count,median);
    }

    @Test
    public void calcTestSixth() {
        int y =1;
        int y1 = 2;
        int y2 = 3;

        QueueManagementSystem[] systems = new QueueManagementSystem[2];
        systems[0] = new QueueManagementSystem("Bank");
        createTicket(systems[0],y);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y1);
        systems[0].toNextWorkDay();
        createTicket(systems[0],y2);
        systems[1] = new QueueManagementSystem("Bank2");
        createTicket(systems[1],y);
        int[]min=new int[]{1,2,1};
        int[]max=new int[]{1,2,3};
        double[]average=new double[]{1,2,(double)4/2};
        long[]count=new long[]{1,2,4};
        double[]median=new double[]{1,2,2};
        test(systems,min,max,average,count,median);

    }
    public static void createTicket(QueueManagementSystem system,int y){
        for (int i=0;i<y;i++){
        system.getNextTicket();}
    }

    public static void test(QueueManagementSystem[] systems, int[] min, int[] max, double[] average, long[] count, double[] median) {
        for (int i = 0; i < min.length; i++) {
            Assertions.assertEquals(min[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getMin());
            Assertions.assertEquals(max[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getMax());
            Assertions.assertEquals(average[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getAverage());
            Assertions.assertEquals(count[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getCount());
            Assertions.assertEquals(median[i], QueueManagementSystemUtils.calcStatisticByDays(systems)[i].getMedian());
        }

    }


}