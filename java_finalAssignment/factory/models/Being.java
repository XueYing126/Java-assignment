package factory.models;
public abstract class Being {
	
	//Attributes
	private String name;
	private String code;
	
	
	//Constructors
	//Empty Constructor
	public Being(){
		this.name = "Robert";
		this.code = "dpolsj";		
	}
	
	//Constructor with arguments	
	public Being(String name, String code){		
		this.name = name;
		this.code = code;
	}

	
	//Getters and Setters
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;			
	}
	
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	@Override
	public String toString(){
		return "name: "+this.name+ " code: "+this.code ;
		
		
	}
	
}