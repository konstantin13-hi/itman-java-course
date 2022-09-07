package entities;

public class Cuboid {
    private int edgeA;
    private int edgeB;
    private int edgeC;

    /**
     * Setting cuboid parameters.
     *
     * @param a the first term.
     * @param b the second term.
     * @param c the third term
     * @cpu 0(1)
     * @ram 0(1)
     */
    public Cuboid(int a, int b, int c) {
        this.edgeA = a;
        this.edgeB = b;
        this.edgeC = c;
    }

    public int getEdgeA() {
        return edgeA;
    }

    public int getEdgeB() {
        return edgeB;
    }

    public int getEdgeC() {
        return edgeC;
    }

    /**
     * Calc surface area.
     *
     * @return result of surface Area
     * @cpu 0(1)
     * @ram 0(1)
     */
    public long calcSurfaceArea() {
        return 2 * ((long) edgeA * edgeB + (long) edgeB * edgeC + (long) edgeA * edgeC);
    }

    /**
     * Calc volume.
     *
     * @return result of the Volume
     * @cpu 0(1)
     * @ram 0(1)
     */
    public long calcVolume() {
        return (long) edgeA * edgeB * edgeC;
    }

}
