package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuboidTest {
    @Test
    public void calcVolume(){
        int a=3;
        int b=3;
        int c=3;
        Cuboid cuboid = new Cuboid(a,b,c);

        Assertions.assertEquals(27,cuboid.calcVolume());
    }

    @Test
    public void calcSurfaceArea(){
        int a=3;
        int b=3;
        int c=3;
        Cuboid cuboid = new Cuboid(a,b,c);
        Assertions.assertEquals(54,cuboid.calcSurfaceArea());
    }


}