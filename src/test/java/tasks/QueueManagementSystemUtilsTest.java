package tasks;

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



}