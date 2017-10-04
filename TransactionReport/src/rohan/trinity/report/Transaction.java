package rohan.trinity.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is to identify the
 * attributes for a given entity.
 * Create the report as provided by
 * each entity.
 * @author Rohan
 *
 */
public class Transaction {

	private String entity;
	private char instruction;
	private double agreedFx;
	private String currency;
	private String instructionDate;
	private String settlementDate;
	private int units;
	private double pricePerUnit;
	private double amount;

	//To check the weekends Sat/Sun for currency apart from AED/SAR &
	// Fri/Sat for currency AED/SAR
	static SimpleDateFormat sdf= new SimpleDateFormat("dd MMM yyyy");
	static SimpleDateFormat day= new SimpleDateFormat("E");

	public Transaction(String entity, char instruction, double agreedFx, String currency, String instructionDate,
			String settlementDate, int units, double pricePerUnit) {
		super();
		this.entity = entity;
		this.instruction = instruction;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = checkSettlementDate(settlementDate);
		this.units = units;
		this.pricePerUnit = pricePerUnit;
		this.amount = (pricePerUnit * units * agreedFx);
	}

	/**
	 * This method checks if the settlement date
	 * is not a weekend based on currency code.
	 * @param date
	 * @return
	 */
	public String checkSettlementDate(String date){
		try {
			Date d= sdf.parse(date);
			if(currency!="AED" && currency!="SAR"){
				if(day.format(d).equals("Sat")){
					date=String.format("%02d",Integer.parseInt(date.substring(0,2))+2)+date.substring(2,date.length());
				}
				else if(day.format(d).equals("Sun")){
					date=String.format("%02d",Integer.parseInt(date.substring(0,2))+1)+date.substring(2,date.length());
				}
			}else{
				if(day.format(d).equals("Fri")){
					date=String.format("%02d",Integer.parseInt(date.substring(0,2))+2)+date.substring(2,date.length());
				}
				else if(day.format(d).equals("Sat")){
					date=String.format("%02d",Integer.parseInt(date.substring(0,2))+1)+date.substring(2,date.length());
				}
			}

		} catch (ParseException e) {
			System.out.println("Date to be entered in correct format e.g. 01 Jan 2017(dd MMM yyyy)");
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * This method retrieves a financial entity
	 * whose shares are to be bought or sold.
	 * @return entity
	 */
	public String getEntity() {
		return entity;
	}

	/**
	 * This method retrieves An instruction to
	 * buy or sell.
	 * @return instruction
	 */
	public char getInstruction() {
		return instruction;
	}

	/**
	 * This method retrieves the foreign exchange
	 * rate with respect to USD that was agreed.
	 * @return agreedFx
	 */
	public double getAgreedFx() {
		return agreedFx;
	}

	/**
	 * This method retrieves the currency code.
	 * @return currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * This method retrieves date on which the 
	 * instruction was sent to JP Morgan by various 
	 * clients.
	 * @return instructionDate
	 */
	public String getInstructionDate() {
		return instructionDate;
	}

	/**
	 * This method retrieves the date on which the
	 * client wished for the instruction to be settled
	 * with respect to instruction date.
	 * @return settlementDate 
	 */
	public String getSettlementDate() {
		return settlementDate;
	}

	/**
	 * This method retrieves number of shares
	 * to be bought or sold
	 * @return units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * This method retrieves price Per Unit for
	 * shares.
	 * @return pricePerUnit
	 */
	public double getPricePerUnit() {
		return pricePerUnit;
	}

	/**
	 * This method retrieves amount of a trade.
	 * @return amount
	 */
	public double getAmount() {
		return amount;
	}



}
