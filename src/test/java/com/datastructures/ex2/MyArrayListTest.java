package com.datastructures.ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


public class MyArrayListTest {

    protected List<Integer> mylist;
    protected List<Integer> list;


    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyArrayList<Integer>();
        mylist.addAll(list);
    }

    /**
     * Test method for {@link MyArrayList#MyArrayList()}.
     */
    @Test
    public void testMyList() {
        assertEquals(mylist.size(), 3);
    }

    /**
     * Test method for {@link MyArrayList#add(Object)}.
     */
    @Test
    public void testAddT() {
        for (int i = 4; i < 20; i++) {
            mylist.add(i);
        }
        //System.out.println(Arrays.toString(mal.toArray()));
        assertEquals(mylist.get(18), 19);
    }

    /**
     * Test method for {@link MyArrayList#add(int, Object)}.
     */
    @Test
    public void testAddIntT() {
        mylist.add(1, 5);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(1), is(new Integer(5)));
        assertThat(mylist.size(), is(4));

        try {
            mylist.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        } // good

        try {
            mylist.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        } // good

        mylist.add(0, 6);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(0), is(6));

        mylist.add(5, 7);
        //System.out.println(Arrays.toString(mal.toArray()));
        assertThat(mylist.get(5), is(new Integer(7)));
    }

    /**
     * Test method for {@link MyArrayList#addAll(java.util.Collection)}.
     */
    @Test
    public void testAddAllCollectionOfQextendsT() {
        mylist.addAll(list);
        mylist.addAll(list);
        mylist.addAll(list);
        assertEquals(mylist.size(), 12);
        assertEquals(mylist.get(5), 3);
    }

    /**
     * Test method for {@link MyArrayList#clear()}.
     */
    @Test
    public void testClear() {
        mylist.clear();
        assertEquals(mylist.size(), 0);
    }

    /**
     * Test method for {@link MyArrayList#contains(Object)}.
     */
    @Test
    public void testContains() {
        assertTrue(mylist.contains(1));
        assertFalse(mylist.contains(4));
        assertFalse(mylist.contains(null));
        mylist.add(null);
        assertTrue(mylist.contains(null));
    }

    /**
     * Test method for {@link MyArrayList#containsAll(java.util.Collection)}.
     */
    @Test
    public void testContainsAll() {
        assertTrue(mylist.containsAll(list));
    }

    /**
     * Test method for {@link MyArrayList#get(int)}.
     */
    @Test
    public void testGet() {
        assertEquals(mylist.get(1), 2);
    }

    /**
     * Test method for {@link MyArrayList#indexOf(Object)}.
     */
    @Test
    public void testIndexOf() {
        assertEquals(mylist.indexOf(1), 0);
        assertEquals(mylist.indexOf(2), 1);
        assertEquals(mylist.indexOf(3), 2);
        assertEquals(mylist.indexOf(4), -1);
    }

    /**
     * Test method for {@link MyArrayList#indexOf(Object)}.
     */
    @Test
    public void testIndexOfNull() {
        assertThat(String.valueOf(mylist.indexOf(null)), is(-1));
        mylist.add(null);
        assertThat(String.valueOf(mylist.indexOf(null)), is(3));
    }

    /**
     * Test method for {@link MyArrayList#isEmpty()}.
     */
    @Test
    public void testIsEmpty() {
        assertFalse(mylist.isEmpty());
        mylist.clear();
        assertTrue(mylist.isEmpty());
    }

    /**
     * Test method for {@link MyArrayList#iterator()}.
     */
    @Test
    public void testIterator() {
        Iterator<Integer> iter = mylist.iterator();
        assertEquals(iter.next(), 1);
        assertEquals(iter.next(), 2);
        assertEquals(iter.next(), 3);
        assertFalse(iter.hasNext());
    }

    /**
     * Test method for {@link MyArrayList#lastIndexOf(Object)}.
     */
    @Test
    public void testLastIndexOf() {
        mylist.add(2);
        assertEquals(mylist.lastIndexOf(new Integer(2)), 3);
    }

    /**
     * Test method for {@link MyArrayList#remove(Object)}.
     */
    @Test
    public void testRemoveObject() {
        boolean flag = mylist.remove(new Integer(2));
        assertTrue(flag);
        assertEquals(mylist.size(), 2);
        assertEquals(mylist.get(1), 3);
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(new Integer(1));
        assertTrue(flag);
        assertEquals(mylist.size(), 1);
        assertEquals(mylist.get(0), 3);
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(new Integer(5));
        assertFalse(flag);
        assertEquals(mylist.size(), 1);
        assertEquals(mylist.get(0), 3);
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = mylist.remove(new Integer(3));
        assertTrue(flag);
        assertEquals(mylist.size(), 0);
        //System.out.println(Arrays.toString(mal.toArray()));
    }

    /**
     * Test method for {@link MyArrayList#remove(int)}.
     */
    @Test
    public void testRemoveInt() {
        Integer val = mylist.remove(1);
        assertEquals(val, 2);
        assertEquals(mylist.size(), 2);
        assertEquals(mylist.get(1), 3);
    }

    /**
     * Test method for {@link MyArrayList#removeAll(java.util.Collection)}.
     */
    @Test
    public void testRemoveAll() {
        mylist.removeAll(list);
        assertEquals(mylist.size(), 0);
    }

    /**
     * Test method for {@link MyArrayList#set(int, Object)}.
     */
    @Test
    public void testSet() {
        Integer val = mylist.set(1, 5);
        assertEquals(val, 2);

        val = mylist.set(0, 6);
        assertEquals(val, 1);

        val = mylist.set(2, 7);
        assertEquals(val, 3);

        // return value should be 2
        // list should be [6, 5, 7]
        assertEquals(mylist.get(0), 6);
        assertEquals(mylist.get(1), 5);
        assertEquals(mylist.get(2), 7);
        //System.out.println(Arrays.toString(mal.toArray()));

        try {
            mylist.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        } // good

        try {
            mylist.set(10, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {
        } // good
    }

    /**
     * Test method for {@link MyArrayList#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(mylist.size(), 3);
    }

    /**
     * Test method for {@link MyArrayList#subList(int, int)}.
     */
    @Test
    public void testSubList() {
        mylist.addAll(list);
        List<Integer> sub = mylist.subList(1, 4);
        assertEquals(sub.get(1), 3);
    }

    /**
     * Test method for {@link MyArrayList#toArray()}.
     */
    @Test
    public void testToArray() {
        Object[] array = mylist.toArray();
        assertEquals((Integer) array[0], 1);
    }
}