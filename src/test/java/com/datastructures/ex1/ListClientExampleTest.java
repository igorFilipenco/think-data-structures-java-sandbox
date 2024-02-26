package com.datastructures.ex1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;


class ListClientExampleTest {
    /**
     * Test method for {@link ListClientExample}.
     */
    @Test
    public void testListClientExample() {
        ListClientExample lce = new ListClientExample();

        @SuppressWarnings("rawtypes")
        List list = lce.getList();
        assertThat(list, instanceOf(ArrayList.class));
    }
}