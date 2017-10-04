package rohan.trinity.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import rohan.trinity.report.Transaction;

public class TransactionTester {
	//Change the values to check different test cases
	private static Transaction transaction=new Transaction("foo", 'B', 0.50,
			"AED", "01 Jan 2016", "17 Sep 2017", 200, 100.25);
	
	@Test
	public void test_Transaction() {
		assertEquals("foo", transaction.getEntity());
		assertEquals('B', transaction.getInstruction());
		assertEquals(0.50, transaction.getAgreedFx(),0.01);
		//Change currency to AED/SAR to check different weekends.
		assertEquals("AED", transaction.getCurrency());
		assertEquals("01 Jan 2016", transaction.getInstructionDate());
		//Check for weekends.
		assertEquals("17 Sep 2017", transaction.getSettlementDate());
		assertEquals(200, transaction.getUnits());
		assertEquals(100.25, transaction.getPricePerUnit(),0.01);		
	}
	
	@Test
	public void test_checkSettlementDate(){
		//Change values to get the next working day.
		String date="02 Jan 2016";
		assertEquals("03 Jan 2016",transaction.checkSettlementDate(date));
	}
}
