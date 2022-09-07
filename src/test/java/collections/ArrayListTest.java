package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tasks.MyString;

class ArrayListTest extends AbstractListTest {
    @Override
    protected List createList() {
        return new ArrayList();
    }

    @Override
    protected List of(final Object... elements) {
        return ArrayList.of(elements);
    }

}