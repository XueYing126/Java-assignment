package factory;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class OompaLoompaSong {

	private static ArrayList<String> OompaLoompaSongs;
	private static ArrayList<String> shortcut_OompaLoompaSong;
	
	//Constructors:
	public OompaLoompaSong(){
		OompaLoompaSongs = new ArrayList<String>() ;
 
        String fileName = "OompaLoompaSong.txt";
        String line = null;

        try {
    
            FileReader fileReader =  new FileReader(fileName);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
				OompaLoompaSongs.add(line);               
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
		
	} 
	
	// define how many lines  the song shall have
	public OompaLoompaSong(int lines){		
		this();
		randomline(lines);		
	}       

	public void randomline(int lines){
		Collections.shuffle(OompaLoompaSongs);
		shortcut_OompaLoompaSong = new ArrayList<String>() ;
		for(int i=0;i<lines;i++){
			shortcut_OompaLoompaSong.add(OompaLoompaSongs.get(i));
			System.out.println(OompaLoompaSongs.get(i));
		}		
	}
    // Return a String with the song
     public String sing(){
		 Collections.shuffle(shortcut_OompaLoompaSong);
		 return shortcut_OompaLoompaSong.get(0);
		 
	 }
	
	
	
	
	
   

	 
    
}
