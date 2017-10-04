package rohan.trinity.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * This is the main class
 * which is required to generate the final 
 * report as per requirements.
 * @author Rohan
 *
 */
public class ReportGenerator {
	public static double sumIncoming=0;
	public static double sumOutgoing=0;
	public static int rankOutgoing=0;
	public static int rankIncoming=0;
	
	//To get today's date.
	static SimpleDateFormat sdf= new SimpleDateFormat("dd MMM yyyy");

	/**
	 * This method retrieves the outgoing amount for 
	 * transactions having today's settlement day.
	 * @return double
	 */
	public static double settledOutgoingAmount(){
		for(Transaction t:EntityGenerator.getTransactionList()){
			if(t.getInstruction()=='B' && t.getSettlementDate().equals(sdf.format(new Date()))){
				sumOutgoing+=t.getAmount();
			}
		}
		return sumOutgoing;
	}
	
	/**
	 * This method retrieves the incoming amount for
	 * transactions having today's settlement day.
	 * @return double
	 */
	public static double settledIncomingAmount(){
		for(Transaction t:EntityGenerator.getTransactionList()){
			if(t.getInstruction()=='S' && t.getSettlementDate().equals(sdf.format(new Date()))){
				sumIncoming+=t.getAmount();
			}
		}
		return sumIncoming;
	}

	//Should be used to only generate logic.
	public static void main(String[] args) {
		//First generate sample data.
		EntityGenerator.generateEntity();
		
		System.out.println("Outgoing amount settled today is: $"+settledOutgoingAmount());
		System.out.println("Incoming amount settled today is: $"+settledIncomingAmount());
		
		System.out.println("----------RANKS OF ENTITIES FOR OUTGOING AMOUNT--------------");
		for(Map.Entry<String, Double> entry: EntityGenerator.getHashMapOutgoing().entrySet()){
			System.out.println("Rank of entity "+entry.getKey()+" is "+(++rankOutgoing)+" with outgoing amount: $"+entry.getValue());
		}
		System.out.println("----------RANKS OF ENTITIES FOR INCOMING AMOUNT--------------");
		for(Map.Entry<String, Double> entry: EntityGenerator.getHashMapIncoming().entrySet()){
			System.out.println("Rank of entity "+entry.getKey()+" is "+(++rankIncoming)+" with incoming amount: $"+entry.getValue());
		}
		System.out.println("-------------------------------------------------------------");

	}

}
