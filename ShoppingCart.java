
import java.io.BufferedReader;																				
import java.io.File;																						
import java.io.FileReader;																					
import java.io.FileWriter;																					
import java.io.IOException;																					
import java.io.PrintWriter;																					
import java.text.SimpleDateFormat;																			
import java.util.Date;																						

public class ShoppingCart extends User {																	
	private String[] content;																				
	public String[] getContent(String username) {															
		try {																								
			File f = new File("Cart_" + username + ".txt");													
			if (f.exists()) { 																				
				FileReader fr = new FileReader("Cart_" + username + ".txt");								
				BufferedReader br = new BufferedReader(fr);													
				String stringRead = br.readLine();															
				int counter = 0;																			
				while (stringRead != null) {																
					stringRead = br.readLine(); 															
					counter++;																				
				}																							
				br.close();																					
				FileReader fr1 = new FileReader("Cart_" + username + ".txt");								
				BufferedReader br1 = new BufferedReader(fr1);												
				String[] arr = new String[counter];															
				int i = 0;																					
				String stringRead1 = br1.readLine();														
				while (stringRead1 != null) {																
					arr[i] = stringRead1;																	
					stringRead1 = br1.readLine(); 															
					i++;																					
				}																							
				br1.close();																				
				this.content = arr;																			
				return arr;																					
			} else {																						
				PrintWriter toWrite = new PrintWriter("Cart_" + username + ".txt","UTF-8");					
				toWrite.close();																			
			}																								
		} catch (IOException ioe) {																			
			ioe.printStackTrace();																			
		}																									
		String[] emp = new String[1];																		
		emp[0] = " ";																						
		return emp;																							
	}																										
	public boolean addItem(String username,String sNO, String title, int quantity) {						
		try {																								
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");										
			String date = fmt.format(new Date());															
			FileWriter fileWriter= new FileWriter("Cart_" + username + ".txt",true);						
			fileWriter.write(sNO+","+title + "," + date + "," + quantity);									
			fileWriter.write("\r\n");																		
			fileWriter.close();																				
			return true;																					
		} catch (																							
		IOException ioe) {																					
			ioe.printStackTrace();																			
		}																									
		return false;																						
	}																										
}																											