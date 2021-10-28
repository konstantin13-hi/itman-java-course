package entities;

public class Cuboid {
    private int a;
    private int b;
    private int c;

    /**
     *Setting cuboid parameters
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param a the first term.
     * @param b the second term.
     * @param c the third term
     */
    public Cuboid(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    public int getC() {
        return c;
    }

    /**
     *Calc surface area
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return result of surface Area
     */
    public long calcSurfaceArea() {
        return 2 * ((long) a * b + (long) b * c + (long) a * c);
    }

    /**
     *Calc volume
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return result of the Volume
     */
    public long calcVolume() {
        return (long) a * b * c;
    }

}
