package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Task551Test {
    @Nested
    public class Build {
        @Test
        void buildShouldReturnNodContainingElementsWhenNodeIsEmpty() {
            Task551.Node node = Task551.buildLinkedList();
            Assertions.assertEquals(12, node.getNext().getPrev().getElement());
            Assertions.assertEquals(99, node.getNext().getNext().getPrev().getNext().getPrev().getElement());
        }
    }
}