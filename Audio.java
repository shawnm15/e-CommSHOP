
import java.io.File;																										
import java.io.FileNotFoundException;																						
import java.util.Scanner;																									

public class Audio extends Item {																							
	protected String artistName;																							
	@Override																												
	public String getInfo(int input) {																						
		try {																												
			Scanner sc = new Scanner(new File("CDs.txt"));																	
			Scanner sc1 = new Scanner(new File("MP3.txt"));																	
			String[] arr = new String[8]; 																					
			int i = 0;																										
			int num[] = new int[100];																						
			String[] title = new String[100];																				
			String[] artistname = new String[100];																			
			String[] quantity = new String[100];																			
			String[] type = new String[100];																				
			String info = "";																								
			while (sc.hasNextLine()) {																						
				String readLine = sc.nextLine();																			
				arr = readLine.split(",\\s*");																				
				num[i] = Integer.parseInt(arr[0]);																			
				title[i] = arr[1];																							
				artistname[i] = arr[2];																						
				quantity[i] = arr[4];																						
				type[i] = "CDs";																							
				i++;																										
			}																												
			while (sc1.hasNextLine()) {																						
				String read = sc1.nextLine();																				
				arr = read.split(",\\s*");																					
				num[i] = Integer.parseInt(arr[0]);																			
				title[i] = arr[1];																							
				artistname[i] = arr[2];																						
				quantity[i] = arr[4];																						
				type[i] = "MP3";																							
				i++;																										
			}																												
			for (int j = 0; j < i; j++) {																					
				if (num[j] == input) {																						
					info += num[j] + "," + title[j] + "," + artistname[j] + "," + quantity[j] + "," + type[j];				
					artistName = artistname[j];																				
					return info;																							
				}																											
			}																												
			sc.close();																										
			sc1.close();																									
		} catch (FileNotFoundException fnfe) {																				
			System.out.println("Unable to find file!");																		
		} catch (Exception ioe) {																							
			ioe.printStackTrace();																							
		}																													
		return "";																											
	}																														
	@Override																												
	public int getPrice(int input) {																						
		try {																												
			Scanner sc = new Scanner(new File("CDs.txt"));																	
			Scanner sc1 = new Scanner(new File("MP3.txt"));																	
			String[] arr = new String[8]; 																					
			int i = 0;																										
			int num[] = new int[100];																						
			int price[] = new int[100];																						
			while (sc.hasNextLine()) {																						
				String readLine = sc.nextLine();																			
				arr = readLine.split(",\\s*");																				
				num[i] = Integer.parseInt(arr[0]);																			
				price[i] = Integer.parseInt(arr[3]);																		
				i++;																										
			}																												
			while (sc1.hasNextLine()) {																						
				String read = sc1.nextLine();																				
				arr = read.split(",\\s*");																					
				num[i] = Integer.parseInt(arr[0]);																			
				price[i] = Integer.parseInt(arr[3]);																		
				i++;																										
			}																												
			for (int j = 0; j < i; j++) {																					
				if (num[j] == input) {																						
					this.price = price[j];																					
					this.sN0=num[j];																						
					return price[j];																						
				}																											
			}																												
			sc.close();																										
			sc1.close();																									
		} catch (FileNotFoundException fnfe) {																				
			System.out.println("Unable to find file!");																		
		} catch (Exception ioe) {																							
			ioe.printStackTrace();																							
		}																													
		return 0;																											
	}																														
}																															
