package rohan.trinity.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import rohan.trinity.report.ReportGenerator;

public class ReportGeneratorTester {

	@Test
	public void test_settledOutgoingAmount() {
		ReportGenerator.sumOutgoing=50.0;
		ReportGenerator.sumOutgoing+=100.00;
		assertEquals(10675.0, ReportGenerator.settledOutgoingAmount(),.01);
	}
	
	@Test
	public void test_settledIncomingAmount() {
		ReportGenerator.sumIncoming=150.0;
		ReportGenerator.sumIncoming+=100.00;
		assertEquals(5101.0, ReportGenerator.settledIncomingAmount(),.01);
	}

}
