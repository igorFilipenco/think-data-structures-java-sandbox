/**
 * 
 */
package com.datastructures.ex3;

import java.util.ArrayList;

import com.datastructures.ex2.MyArrayListTest;
import org.junit.jupiter.api.BeforeEach;


/**
 * @author downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

	/**
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		mylist = new MyLinkedList<Integer>();
		mylist.addAll(list);
	}
}
