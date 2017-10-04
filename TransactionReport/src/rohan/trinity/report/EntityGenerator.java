package rohan.trinity.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class EntityGenerator {

	private static ArrayList<Transaction> transactionList= new ArrayList<>();
	private static HashMap<String, Double> hashMapIncoming= new HashMap<>();
	private static HashMap<String, Double> hashMapOutgoing= new HashMap<>();

	/**
	 * To generate sample transaction for given clients/entities.
	 */
	public static void generateEntity(){
		Transaction t1=new Transaction("foo", 'B', 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25);
		Transaction t2=new Transaction("foo2", 'B', 0.50, "SGP", "01 Jan 2016", "04 Oct 2017", 200, 105.25);
		Transaction t3=new Transaction("bar", 'S', 0.22, "AED", "05 Jan 2016", "07 Jan 2016", 200, 100.25);
		Transaction t4=new Transaction("bar2", 'S', 0.22, "AED", "05 Jan 2016", "04 Oct 2017", 200, 110.25);
		Transaction t5=new Transaction("bar", 'S', 0.22, "AED", "05 Jan 2016", "07 Jan 2016", 200, 110.25);

		transactionList.add(t1);
		transactionList.add(t2);
		transactionList.add(t3);
		transactionList.add(t4);
		transactionList.add(t5);

		//Two different HashMaps are taken to reduce the time complexity when the number
		//of transactions are of greater amount. The idea is to separate the incoming and outgoing
		//transactions based on instruction-> 'B/S' which plays a major role, if the data was taken
		//from a file/database/UI.
		for(Transaction t: transactionList){
			if(t.getInstruction()=='B'){
				if(!hashMapOutgoing.containsKey(t.getEntity())){
					hashMapOutgoing.put(t.getEntity(), t.getAmount());
				}else{
					hashMapOutgoing.put(t.getEntity(), hashMapOutgoing.get(t.getEntity())+t.getAmount());
				}
			}else{
				if(!hashMapIncoming.containsKey(t.getEntity())){
					hashMapIncoming.put(t.getEntity(), t.getAmount());
				}else{
					hashMapIncoming.put(t.getEntity(), hashMapIncoming.get(t.getEntity())+t.getAmount());
				}
			}
		}

		//We need to sort the Map to generate the ranks of the entities based on 
		//incoming and outgoing amount.
		hashMapOutgoing=(HashMap<String, Double>)sortByValue(hashMapOutgoing);
		hashMapIncoming=(HashMap<String, Double>)sortByValue(hashMapIncoming);

	}

	/**
	 * This method is used to sort the HashMap 
	 * by values to get a unique pair of Entity and Amount 
	 * in descending order.
	 * @param map
	 * @return
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		return map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(e1, e2) -> e1, 
						LinkedHashMap::new
						));
	}

	/**
	 * This method retrieves the list which contains sample transactions.
	 * @return transactionList
	 */
	public static ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	/**
	 * This method retrieves the Map which contains incoming transactions.
	 * @return hashMapIncoming
	 */
	public static HashMap<String, Double> getHashMapIncoming() {
		return hashMapIncoming;
	}

	/**
	 * This method retrieves the Map which contains outgoing transactions.
	 * @return hashMapOutgoing
	 */
	public static HashMap<String, Double> getHashMapOutgoing() {
		return hashMapOutgoing;
	}



}
