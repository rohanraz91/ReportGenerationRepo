package rohan.trinity.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EntityGeneratorTester.class, ReportGeneratorTester.class, TransactionTester.class })
public class AllTests {

}
