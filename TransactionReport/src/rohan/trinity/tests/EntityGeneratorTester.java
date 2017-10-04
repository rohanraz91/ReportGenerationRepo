package rohan.trinity.tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import rohan.trinity.report.EntityGenerator;

public class EntityGeneratorTester {

	@Test
	public void test_sortByValue() {
		HashMap<String, Double> hmTest=new HashMap<>();
		//We can generate random double values and put them
		//in the Map then iterate and check that each value  
		//is greater than next iterated value.
		hmTest.put("foo",100.00);
		hmTest.put("bar",101.20);
		hmTest.put("loo",120.50);
		
		assertEquals(120.50,EntityGenerator.sortByValue(hmTest).values().toArray()[0]);
		assertEquals(101.20,EntityGenerator.sortByValue(hmTest).values().toArray()[1]);
		assertEquals(100.00,EntityGenerator.sortByValue(hmTest).values().toArray()[2]);
	}
	
	@Test
	public void test_generateEntity(){
		EntityGenerator.generateEntity();
		//Can check for multiple values in a list
		assertEquals("foo",EntityGenerator.getTransactionList().get(0).getEntity());
		assertEquals(10025.0,EntityGenerator.getTransactionList().get(0).getAmount(),0.01);
		//Can test if hashMap was generated properly(for instance check size).
		assertEquals(2,EntityGenerator.getHashMapIncoming().size());
		assertEquals(2,EntityGenerator.getHashMapOutgoing().size());
		//Various combinations can be checked.
	}
}
