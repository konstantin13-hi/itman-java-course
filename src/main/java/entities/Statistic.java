package entities;

import tasks.QueueManagementSystem;
import tasks.QueueManagementSystemUtils;


public class Statistic {
    private int min;
    private int max;
    private long count;
    private double average;
    private double median;

    public Statistic(int min, int max, long count, double average, double median) {
        this.min = min;
        this.max = max;
        this.count = count;
        this.average = average;
        this.median = median;
    }
    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public long getCount() {
        return count;
    }

    public double getAverage() {
        return average;
    }

    public double getMedian() {
        return median;
    }
    public void setMin(int min) {
        if (min >= 0) {
            this.min = min;
        }
    }

    public void setMax(int max) {
        if (max >= 0) {
            this.max = max;
        }
    }
    public void setCount(long count) {
        if (count >= 0) {
            this.count = count;
        }
    }
    public void setAverage(double average) {
        if (average >= 0) {
            this.average = average;
        }
    }

    public void setMedian(double median) {
        if (median >= 0) {
            this.median = median;
        }
    }

    public String toString() {
        return "Statistic{min=" + min + ", max=" + max + ", count=" + count + ", average=" + average + ", median=" + median + "}";
    }

    public boolean equals(Statistic that) {
        if (that == null) {
            return false;
        }

        return that.min == this.min &&
                that.max == this.max &&
                that.count == this.count &&
                that.average == this.average &&
                that.median == this.median;
    }
}
