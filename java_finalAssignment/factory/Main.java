package factory;
import java.util.ArrayList;
public class Main {
    public static void main(String [] args) {
	
	//let's play the OompaLoompaSong here.	
	
	OompaLoompaSong mySong = new OompaLoompaSong(6);
	//// Return a String with the song
	System.out.println("\n---Return a String with the song:---\n ");
	System.out.println(mySong.sing());
	
    }
}
