package factory.models;
public  class OompaLoompa extends Being{
	
	private int height;
	private String favorite_food;
	
	
	//Constructors
	//Empty Constructor
	public OompaLoompa(){
		super();		
	}
	
	//Constructor with arguments	
	public OompaLoompa(String name, String code,int height,String favorite_food){	
		super(name,code);			
		this.height = height;
		this.favorite_food = favorite_food;
	}
	
	//Getters and Setters
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height){
		this.height = height;			
	}
	public String getFavorite_food(){
		return favorite_food;
	}
	
	public void setFavorite_food(String favorite_food){
		this.favorite_food = favorite_food;			
	}
	
	
	@Override
	public String toString(){
		return super.toString()+" height: "+this.height+" favorite food: "+this.favorite_food;
		
		
	}
	
}