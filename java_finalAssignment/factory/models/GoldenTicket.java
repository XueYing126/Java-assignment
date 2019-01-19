package factory.models;;
import java.util.Date;
import java.text.SimpleDateFormat;
public class GoldenTicket {
	private String code;
	private Date raffled;
	private SimpleDateFormat myFormat;

	//Constructors:
	GoldenTicket(){
		myFormat= new SimpleDateFormat("YYYY/MM/dd");
	}
	GoldenTicket(String code, Date raffled){
		this();
		this.code=code;
		this.raffled=raffled;
	}
	
	// Getters and Setters
	public String getCode(){
		return code;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	public String getRaffled(){
		return myFormat.format(raffled);
	}
	
	public void setRaffled(Date raffled){
		this.raffled = raffled;
	}
	
	// If the current ticket has been already raffled
	boolean isRaffled(){
		return raffled!=null;
	}
}