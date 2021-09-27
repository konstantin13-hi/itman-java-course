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

    /**
     * Create the string
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return string
     */
    public String toString() {
        return "Statistic{min=" + min + ", max=" + max + ", count=" + count + ", average=" + average + ", median=" + median + "}";
    }

    /**
     * Make a compare between two statics
     *
     * n=that.length
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param that the first
     * @return result of compare
     */


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
