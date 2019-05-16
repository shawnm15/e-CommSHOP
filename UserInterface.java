

import java.io.*;													
import java.util.*;													

public class UserInterface {										
	private String[] readables; 									
	private String[] audioProducts;									
	private int currentPage; 										

	public UserInterface() {										
		currentPage = 1;											
	}																

	public int getCurrentPage() {									
		return currentPage;											
	}																

	public void changeCurrentPage(int input) {						
		if (input==1){												
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P1();												
			currentPage=1;											
		} else if (input==2){										
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P2();												
			currentPage=2;											
		} else if (input == 3) {									
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P3();												
			currentPage=3;											
		} else if (input == 4) {									
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P4();												
			currentPage=4;											
		}else if (input == 5) {										
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P5();												
			currentPage=5;											
		}else if (input == 6) {										
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P6();												
			currentPage=6;											
		}else if (input == 7) {										
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P7();												
			currentPage=7;											
		}else if (input == 8) {										
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P8();												
			currentPage=8;											
		}else if (input == 9) {										
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P9();												
			currentPage=9;											
		}else if (input == 10) {									
			System.out.println("\n"+"-----------------------------------------------------------\n"); 
			User.P10();												
			currentPage=10;											
		} 															
		else if (input == 11) {
			System.out.println("\n"+"-----------------------------------------------------------"+"\n");
			User.P11();
			currentPage=11;
		}
		
	} 																

	public void getReadables() {									
		try {														
			List<String> tempList = new ArrayList<String>();		
			FileReader fr = new FileReader("Books.txt");			
			BufferedReader br = new BufferedReader(fr);				
			FileReader fr1 = new FileReader("Ebooks.txt");			
			BufferedReader br1 = new BufferedReader(fr1);			
			String addLine;											

			while ((addLine = br.readLine()) != null) {				
				tempList.add(addLine);								
			} 														
			while ((addLine = br1.readLine()) != null) {			
				tempList.add(addLine);								
			} 														
			readables = tempList.toArray(new String[0]);			
			br.close();												
			br1.close();											

		} catch (FileNotFoundException fnfe) {						
			System.out.println("Unable to find file!");				
		} catch (IOException ioe) {									
			ioe.printStackTrace();
		} 															
	} 																

	public void getAudioProducts() {								
		try {														
			List<String> tempList = new ArrayList<String>();		
			FileReader fr = new FileReader("CDs.txt");				
			BufferedReader br = new BufferedReader(fr);				
			FileReader fr1 = new FileReader("MP3.txt");				
			BufferedReader br1 = new BufferedReader(fr1);			
			String addLine;											

			while ((addLine = br.readLine()) != null) {				
				tempList.add(addLine);								
			} 														
			while ((addLine = br1.readLine()) != null) {			
				tempList.add(addLine);								
			} 														
			audioProducts = tempList.toArray(new String[0]);		
			
			br.close();												
			br1.close();											
		} catch (FileNotFoundException fnfe) {						
			System.out.println("Unable to find file!"); 			
		} catch (IOException ioe) {									
			ioe.printStackTrace();									
		} 															
	} 																
}																	
