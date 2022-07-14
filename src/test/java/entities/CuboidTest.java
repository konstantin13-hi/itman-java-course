package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuboidTest {

    @Nested
    public class Volume {

        @Test
        public void calcVolumeShouldCalcVolumeWhenAllSidesAreSame() {
            int a = 3;
            int b = 3;
            int c = 3;
            Cuboid cuboid = new Cuboid(a, b, c);
            Assertions.assertEquals(27, cuboid.calcVolume());
        }
    }

    @Nested
    public class SurfaceArea {
        @Test
        public void calcSurfaceAreaShouldCalcSurfaceAreaWhenAllSidesAreSame() {
            int a = 3;
            int b = 3;
            int c = 3;
            Cuboid cuboid = new Cuboid(a, b, c);
            Assertions.assertEquals(54, cuboid.calcSurfaceArea());
        }
    }
}