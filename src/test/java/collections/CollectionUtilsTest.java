package collections;

import org.apache.logging.log4j.util.PropertySource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {
    @Nested
    public class findMin{
        @Test
        public void shouldWhen(){
            // почему нельзя колекцию написать

            List collection= new ArrayList();
            collection.add(100);
            collection.add(12);
            collection.add(121);
            collection.add(13);
         //  Assertions.assertEquals(12,CollectionUtils.findMin(collection, Comparator::compare));
         //  Assertions.assertEquals(121,CollectionUtils.findMax(collection,  Comparator::compare));
        }
    }

}