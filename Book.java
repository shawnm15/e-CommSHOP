
import java.io.*;														
import java.util.*;														

public class Book extends Readable {									
	@Override															
	public int getPrice(int input) {									
		try {															
			Scanner sc = new Scanner(new File("Books.txt"));			

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
			double priceET;												
			for (int j = 0; j < i; j++) {								
				if (num[j] == input) {									
					priceET=1.02*price[j];								
					return (int)priceET;								
				}														
			}															

			sc.close();													

		}catch (FileNotFoundException fnfe) {							
			System.out.println("Can't find file");						
		} catch (Exception ioe) {										
			ioe.printStackTrace();										
		}																
		return 0;														
	}																	
}																		
