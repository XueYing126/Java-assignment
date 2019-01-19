package factory.models;
//Import the Date package
import java.util.Date;
import java.util.ArrayList;


public  class Kid extends Being{	
	
	//Attributes
	private Date birthday;
	private String place_of_birth;
	private ArrayList<Product> purchased_products;
	
	//Constructors
	//Empty Constructor
	public Kid(){		
		super();
		purchased_products = new ArrayList<Product>(); 		
	}
	
	//Constructor with arguments

	public Kid(String name, String code){				
		super(name,code);		
		purchased_products = new ArrayList<Product>();
	}	
	public Kid(String name, String code,Date birthday,String place_of_birth){	
		super(name,code);			
		this.birthday = birthday;
		this.place_of_birth = place_of_birth;
		purchased_products = new ArrayList<Product>(); 
	}

	
	//Getters and Setters
	public Date getBirthday(){
		return birthday;
	}
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	public String getPlace_of_birth(){
		return place_of_birth;
	}
	
	public void setPlace_of_birth(String place_of_birth){
		this.place_of_birth = place_of_birth;
	}
	

	//public ArrayList<Product> getPurchased_products(){
	//	return purchased_products;
	//}
	
	
	//custom methods
	public void purchase_a_product(Product p){		
		purchased_products.add(p);
	}
	
	
	
	public Boolean getGoldenticket(){
	if (purchased_products.size()==0){return false;}else{
		
		Boolean got=false;
		for(int i=0;i<purchased_products.size();i++){
			if (purchased_products.get(i).hasGoldenTicket()){
				got=true;
			}
		}
		return got;
	}
	}
	
	@Override
	public String toString(){
		return super.toString()+" place_of_birth: "+this.place_of_birth;
		
		
	}
	
	
}