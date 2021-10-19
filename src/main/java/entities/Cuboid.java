package entities;

public class Cuboid {
    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    private int a;
    private int b;

    public int getC() {
        return c;
    }

    private int c;

    /**
     *
     * @param a
     * @param b
     * @param c
     */
    public Cuboid(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     *
     * @return
     */
    public long calcSurfaceArea() {
        return 2 * ((long) a * b + (long) b * c + (long) a * c);
    }

    /**
     *
     * @return
     */
    public long calcVolume() {
        return (long) a * b * c;
    }

}
