package tasks;


import entities.Event;

public class Task439 {

    public static Event findLast(Event[] events){
       Event a = events[0];
        for (int i=0;i<events.length;i++){
            if(events[i].year >a.year){
                a=events[i];
            }
            else if (events[i].year == a.year&&events[i].month> a.month){
                a=events[i];
            }
            else if (events[i].year == a.year&&events[i].month == a.month&&events[i].day>a.day){
                a=events[i];
            }
            else if (events[i].year == a.year&&events[i].month == a.month&&events[i].day==a.day){
                a=events[i];
            }

        }

        return a;

        }

    }


