package factory.models;
import java.util.Date;
public class Product{
	private String description;
	private long barcode;
	private String serialNumber;
	private GoldenTicket prizeTicket;
	private static int num=0;
	
	//Constructors
	//Empty Constructor
	public Product(){
			this.prizeTicket = null;
			num++;
	}
	
	//Constructor with arguments	
	public Product(String description, long barcode,String serialNumber){		
		this.description = description;
		this.barcode = barcode;
		this.serialNumber = serialNumber;
		this.prizeTicket = null;
		num++;
	}
	

	//Getters and Setters
	public long getBarcode(){
		return barcode;
	}
	
	public void setBarcode(long barcode){
		this.barcode = barcode;
	}
	public String getSerialNumber(){
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber){
		this.serialNumber = serialNumber;
	}
	
	public void setGoldenTicket(String code, Date raffled){
		this.prizeTicket = new GoldenTicket(code,raffled) ;
	}
	public String getGoldenTicket(){
		if (hasGoldenTicket()){
		return "GoldenTicket: "+prizeTicket.getCode() +" Date: "+ prizeTicket.getRaffled();}
		else{
			return null;
		}
	}
	
	//custom methods
	public Boolean hasGoldenTicket(){
		return this.prizeTicket != null;
	}
	
	public static int numOfProducts(){
		return num;
	}
	
	@Override
	public String toString(){
		return "description: "+this.description
		+" barcode: "+this.barcode
		+" serialNumber: "+this.serialNumber
		+" prizeTicket: "+this.getGoldenTicket();
		
		
	}
	
}