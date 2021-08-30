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
    public void calcSecond32() {
        QueueManagementSystem[] systems = new QueueManagementSystem[4];
        systems[0] = new QueueManagementSystem("Bank");
        systems[0].getNextTicket();
        systems[0].toNextWorkDay();
        systems[0].getNextTicket();
        systems[0].toNextWorkDay();
        systems[0].getNextTicket();
        systems[0].toNextWorkDay();
        systems[0].getNextTicket();
        systems[1] = new QueueManagementSystem("Bank2");
        systems[1].getNextTicket();
        systems[1].toNextWorkDay();
        systems[1].getNextTicket();
        systems[2] = new QueueManagementSystem("Bank3");
        systems[2].getNextTicket();
        systems[2].toNextWorkDay();
        systems[2].getNextTicket();
        systems[2].toNextWorkDay();
        systems[2].getNextTicket();
        systems[3] = new QueueManagementSystem("Bank3");
        systems[3].getNextTicket();
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMin());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMax());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getAverage());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getCount());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMedian());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMin());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMax());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getAverage());
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getCount());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMedian());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getMin());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getMax());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getAverage());
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getCount());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getMedian());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[3].getMin());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[3].getMax());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[3].getAverage());
        Assertions.assertEquals(4, QueueManagementSystemUtils.calcStatisticByDays(systems)[3].getCount());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[3].getMedian());
    }

    @Test
    public void calcSecond321() {
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

        Assertions.assertEquals(10, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMin());
        Assertions.assertEquals(10, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMax());
        Assertions.assertEquals(10, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getAverage());
        Assertions.assertEquals(10, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getCount());
        Assertions.assertEquals(10, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMedian());
        Assertions.assertEquals(20, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMin());
        Assertions.assertEquals(30, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMax());
        Assertions.assertEquals(25, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getAverage());
        Assertions.assertEquals(50, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getCount());
        Assertions.assertEquals(25, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMedian());

    }

    @Test
    public void calcSecond31() {
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


        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMin());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMax());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getAverage());
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getCount());
        Assertions.assertEquals(1, QueueManagementSystemUtils.calcStatisticByDays(systems)[0].getMedian());
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMin());
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMax());
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getAverage());
        Assertions.assertEquals(6, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getCount());
        Assertions.assertEquals(2, QueueManagementSystemUtils.calcStatisticByDays(systems)[1].getMedian());
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getMin());
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getMax());
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getAverage());
        Assertions.assertEquals(9, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getCount());
        Assertions.assertEquals(3, QueueManagementSystemUtils.calcStatisticByDays(systems)[2].getMedian());
    }

    public static void createTicket(QueueManagementSystem system,int y){
        for (int i=0;i<y;i++){
        system.getNextTicket();}
    }




}