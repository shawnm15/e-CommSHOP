

import java.io.*;
import java.util.*;

public class User {

	private String[] readables; 
	private String username; 
	private static int input; 
	private static int quantity; 
	public static String holder; 

	public void setUsername(String user) { 
		this.username = user; 
	} 

	public String getUsername() { 
		return this.username; 
	} 

	public static void P1() { 
		try {
			UserInterface ui = new UserInterface(); 
													
			System.out.println("1.Sign in"); 
												
			System.out.println("2.Sign up"); 
												
			System.out.print("Choose your option: "); 
														
														
			Scanner sc = new Scanner(System.in); 
			int input = sc.nextInt(); 
			if (input == 2) { 
				ui.changeCurrentPage(2); 
											
			} else if (input == 1) { 
				ui.changeCurrentPage(3); 
											
			}
			else{
				System.out.println("Input Error");
				ui.changeCurrentPage(1);
			}
			sc.close(); 

		} catch (InputMismatchException e) { 
			
			System.out.println("Input Error");
			UserInterface ui = new UserInterface();
			ui.changeCurrentPage(1)	;						
		} 

	} 

	public static void P2() { 
		UserInterface ui = new UserInterface(); 

		System.out.print("Choose your username: "); 
													
		Scanner sc = new Scanner(System.in); 
		User userobj = new User(); 
		userobj.setUsername(sc.next()); 
		String userget = userobj.getUsername(); 
		try { 
				
			FileWriter fw = new FileWriter("Users.txt", true); 
																
																
																
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(userget);
			bw.newLine();
			bw.close(); 

			System.out.println("\nUsername successfully added\n"); 
																	
																	
																	
																	
			ui.changeCurrentPage(1); 
										
		} catch (IOException ioe) { 
									
			System.out.println("Exception caught!"); 
														
			ioe.printStackTrace();
		} 
		sc.close();

	} 

	public static void P3() {
		try {
			UserInterface ui = new UserInterface();
													

			System.out.print("Enter your username: ");
														
			Scanner sc = new Scanner(System.in);

			String input = sc.next();
			User userobj = new User();
			userobj.setUsername(input);

			String userget = userobj.getUsername(); 
													
			holder = userget;
			
			FileReader fr = new FileReader("Users.txt");
			BufferedReader br = new BufferedReader(fr);

			String stringRead = "";
			while ((stringRead != null)) {
				if (stringRead.contains(userget)) {
					System.out.println("\nHello Mr." + userget + "\n");
																		
																		
																		
																		
																		
																		
					break;
				} 
				stringRead = br.readLine();
			} 
			if (stringRead == null) {

				ui.changeCurrentPage(4);
										
			} 
				
			ShoppingCart obj = new ShoppingCart();
			String[] arr = obj.getContent(userget);
			
			ui.changeCurrentPage(5);
									
			br.close();
			sc.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("Can't find the file");
														
		} catch (IOException ioe) { 
									
			ioe.printStackTrace();
		} 

	} 

	public static void P4() {
		UserInterface ui = new UserInterface();
		System.out.println("\nNo access\n");
											
		
		ui.changeCurrentPage(1);

	} 

	public static void P5() { 
		try { 
			UserInterface ui = new UserInterface(); 
													

			System.out.println("1.View Items By Category"); 
															
			System.out.println("2.View Shopping Cart"); 
														
														
			System.out.println("3.Sign Out"); 
												
			System.out.println("4.View Previous Orders \n"); 
																
																
																
			System.out.print("Choose your option: "); 
														
														
			Scanner sc = new Scanner(System.in); 
													
			int input = sc.nextInt(); 

			if (input == 3) { 
				
				ui.changeCurrentPage(1); 

			} else if (input == 1) { 
				
				ui.changeCurrentPage(6); 
			} else if (input == 2) { 
				
				ui.changeCurrentPage(7); 

			} else if (input == 4) { 
				
				ui.changeCurrentPage(11); 
			}
			else{
				System.out.println("Input Error");
				ui.changeCurrentPage(5);
			}

			sc.close();

		} catch (InputMismatchException e) { 
												
			System.out.println("Input Error");
			
			UserInterface ui = new UserInterface();
			ui.changeCurrentPage(5)	;			
		} 
			
	}

	public static void P6() { 
		try { 
			UserInterface ui = new UserInterface();
													
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Readables");
												
			System.out.println("2.Audio\n");
											
			System.out.print("Choose your option: "); 
														
														
			System.out.print("\nPress -1 to return to previous menu");
																		
																		
																		
																		
																		
																		

			int input = sc.nextInt();

			if (input == -1) {
				ui.changeCurrentPage(5);
										
			} else if (input == 1) {
				ui.changeCurrentPage(8);
										
			} else if (input == 2) {
				ui.changeCurrentPage(9);
										
			} 
			else {
				System.out.println("Input Error");
				ui.changeCurrentPage(6);
			}
			sc.close();

		} catch (InputMismatchException e) { 
												
			System.out.println("Input Error");

			UserInterface ui = new UserInterface();
			ui.changeCurrentPage(6)	;
			
		} 

	} 

	public static void P7() { 
		try { 
			Scanner sc2 = new Scanner(System.in);
			UserInterface ui = new UserInterface();
													
			ShoppingCart obj = new ShoppingCart();

			User userobj = new User();
			userobj.setUsername(holder);
			String userget = userobj.getUsername();
													
			String[] arr = obj.getContent(userget); 
													
													

			for (int i = 0; i < arr.length; i++) { 
													
													
				System.out.println(arr[i]); 
			} 
			System.out.print("\nPress -1 to return to previous menu: ");
																		
																		
																		
																		
																		
																		
			int inputToContinue = sc2.nextInt();
												

			if (inputToContinue == -1) { 
				ui.changeCurrentPage(5);
										
			} 
			else {
				System.out.println("Input Error");
				ui.changeCurrentPage(7);
			}

		} catch (InputMismatchException e) { 
			
			UserInterface ui = new UserInterface();
			System.out.println("Input Error");
			ui.changeCurrentPage(7);
		} 

	} 

	public static void P8() { 
		try {
			UserInterface ui = new UserInterface(); 
													
			Scanner sc = new Scanner(new File("Books.txt")); 
																
																
																
			Scanner sc1 = new Scanner(new File("Ebooks.txt")); 
																
																
																
			System.out.println("Readables:\n"); 
												
			System.out.println("S.No  Name of the Book\t\t Author  Price($) Quantity in Store  Type"); 
																										
																										
																										
																										

			while (sc.hasNextLine()) { 
										
				String readLine = sc.nextLine(); 
				String[] arr = readLine.split(",\\s*"); 
														
				System.out.printf("%-3s %-30s %-9s %-11s %-12s %-5s %n", arr[0] + ".", arr[1], arr[2], arr[3], arr[4], 
																														
																														
																														
																														
																														
																														
																														
																														
						"Book");
			}
			while (sc1.hasNextLine()) { 
										
				String read = sc1.nextLine(); 
				String[] arr = read.split(",\\s*"); 
													
				System.out.printf("%-3s %-30s %-9s %-11s %-12s %-5s %n", arr[0] + ".", arr[1], arr[2], arr[3], arr[4], 
																														
																														
																														
						"eBook");
			}
			Scanner sc2 = new Scanner(System.in); 
			System.out.println("\nChoose your option: "); 
															
			System.out.print("Press -1 to return to previous menu "); 
																		
																		
																		
																		
																		
			int input1 = sc2.nextInt(); 
			if (input1 == -1) { 
				ui.changeCurrentPage(6); 
			} else { 
				input = input1; 
								
								

				System.out.print("\nEnter Quantity: "); 
														
														

				quantity = sc2.nextInt(); 
											
				

				Readable obj = new Readable(); 
												
				String data = obj.getInfo(input); 
													
													
				String[] holdinfo = data.split(","); 
														
														
				ShoppingCart item = new ShoppingCart(); 
														
														
														
				while (quantity > Integer.parseInt(holdinfo[3])) {
					System.out.print("\nQuantity Over Stock Please Enter New Quantity: ");
					int quantity1 = sc2.nextInt();
					quantity = quantity1;
				}
				
				
				boolean answer = item.addItem(holder, holdinfo[0], holdinfo[1], quantity); 
																							
																							
																							
																							
																							
																							
																							
																							
																							
																							
				if (answer) { 
					System.out.println("\n" + quantity + " " + holdinfo[1] + " " + typefinderP8(input, quantity) 
																													
																													
																													
																													
																													
																													
																													
							+ " successfully added to you cart.");
				} 

				

				System.out.print("\nPress -2 to Continue Shopping or Press 0 to Checkout: "); 
																								
																								
																								
																								
																								
				int inputToContinue = sc2.nextInt(); 
														

				if (inputToContinue == -2) { 
					ui.changeCurrentPage(6); 
				} else if (inputToContinue == 0) { 
													
					ui.changeCurrentPage(10); 
				} 
				else{
					System.out.println("Input Error");
					UserInterface ui1 = new UserInterface();
					ui1.changeCurrentPage(8)	;
				}
			}
			sc.close(); 
			sc1.close(); 
			sc2.close(); 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (InputMismatchException e) { 
												
			System.out.println("Input Error"); 
			UserInterface ui = new UserInterface();
			ui.changeCurrentPage(8)	;
		} 

	} 

	public static void P9() { 
		
		try { 
			UserInterface ui = new UserInterface(); 
			Scanner sc = new Scanner(new File("CDs.txt")); 
															
			Scanner sc1 = new Scanner(new File("MP3.txt")); 
															

			System.out.println("Audio:\n"); 
			System.out.println("S.No  Name\t\t\t Artist  Price($) Quantity in Store  Type"); 
																								
																								
																								
																								

			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				String[] arr = readLine.split(",\\s*"); 
														
														
				System.out.printf("%-3s %-30s %-9s %-11s %-12s %-5s %n", arr[0] + ".", arr[1], arr[2], arr[3], arr[4],
						"CD");
			} 

			while (sc1.hasNextLine()) { 
				String readLine = sc1.nextLine(); 
													
				String[] arr = readLine.split(",\\s*"); 
														
														
				System.out.printf("%-3s %-30s %-9s %-11s %-12s %-5s %n", arr[0] + ".", arr[1], arr[2], arr[3], arr[4],
						"MP3");
			} 
			System.out.println("\nChoose your option: "); 
			System.out.print("Press -1 to return to previous menu "); 
																		

			Scanner sc2 = new Scanner(System.in); 
													

			int input1 = sc2.nextInt(); 
			if (input1 == -1) { 
				
				ui.changeCurrentPage(6); 
			} else { 
				input = input1; 

				System.out.print("\nEnter Quantity: "); 
				Scanner sc3 = new Scanner(System.in); 
				quantity = sc3.nextInt(); 
				Audio obj = new Audio(); 
				String data = obj.getInfo(input); 
													
				String[] holdinfo = data.split(","); 
														
				ShoppingCart item = new ShoppingCart();
				while (quantity > Integer.parseInt(holdinfo[3])) {
					System.out.print("\nQuantity Over Stock Please Enter New Quantity: ");
					int quantity1 = sc2.nextInt();
					quantity = quantity1;
				}
				
				boolean answer = item.addItem(holder, holdinfo[0], holdinfo[1], quantity); 
																							
																							
																							
																							
																							
				if (answer) { 
					System.out.println("\n" + quantity + " " + holdinfo[1] + " " + typefinderP9(input, quantity)
							+ " successfully added to you cart."); 
																	
				} 
				System.out.print("\nPress -2 to Continue Shopping or Press 0 to CheckOut: "); 
																								
				int inputToContinue = sc2.nextInt(); 
				if (input == -1) { 
									
					ui.changeCurrentPage(6); 
				} 
				if (inputToContinue == -2) { 
					ui.changeCurrentPage(6); 
				} else if (inputToContinue == 0) { 
													
					ui.changeCurrentPage(10); 
				}
				else{
					System.out.println("Input Error");
					UserInterface ui1 = new UserInterface();
					ui1.changeCurrentPage(9)	;
				}
			} 
			sc1.close(); 
			sc2.close(); 
			sc.close(); 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
		} catch (InputMismatchException e) { 
			
			System.out.println("Input Error"); 
			UserInterface ui = new UserInterface();
			ui.changeCurrentPage(9)	;
		} catch (NoSuchElementException nfe) { 
												
			System.out.println(""); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		}
	} 

	public static String typefinderP8(int input, int quantity) { 
																	
																	
		try { 
			Scanner sc = new Scanner(new File("Books.txt")); 
																
																
																
																
			Scanner sc1 = new Scanner(new File("Ebooks.txt")); 
																
																
																
																
			String[] arr = new String[8]; 
											
			int i = 0; 
			int num[] = new int[100]; 
										
			String[] title = new String[100]; 
												
			String[] type = new String[100]; 
												
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
													
				title[i] = arr[1]; 
									
				type[i] = "Books"; 
				i++; 
			} 
			while (sc1.hasNextLine()) { 
				String read = sc1.nextLine(); 
				arr = read.split(",\\s*"); 
											
				num[i] = Integer.parseInt(arr[0]); 
													
													
				title[i] = arr[1]; 
									
				type[i] = "Ebooks"; 
				i++; 
			} 
			for (int j = 0; j < i; j++) { 
											
				if (num[j] == input) { 
										
					return type[j]; 
				} 
			} 
			sc.close(); 
			sc1.close(); 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
														
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static String typefinderP9(int input, int quantity) { 
																	
																	
		try { 
			Scanner sc = new Scanner(new File("CDs.txt")); 
															
															
															
			Scanner sc1 = new Scanner(new File("MP3.txt")); 
															
															
															
			String[] arr = new String[8]; 
											
			int i = 0; 
			int num[] = new int[100]; 
										
			String[] title = new String[100]; 
												
			String[] type = new String[100]; 
												
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
													
				title[i] = arr[1]; 
									
				type[i] = "CDs"; 
				i++; 
			} 
			while (sc1.hasNextLine()) { 
				String read = sc1.nextLine(); 
				arr = read.split(",\\s*"); 
											
				num[i] = Integer.parseInt(arr[0]); 
													
													
				title[i] = arr[1]; 
									
				type[i] = "MP3s"; 
				i++; 
			} 
			for (int j = 0; j < i; j++) { 
											
				if (num[j] == input) { 
										
					return type[j]; 
				} 
			} 
			sc.close(); 
			sc1.close(); 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
														
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static void P10() { 
		try { 
			int size = cartReadersize(); 
											
			int[] num = new int[size]; 
			num = cartReadersNO(size); 
			int[] quantity = new int[size]; 
			quantity = cartReaderquantity(size); 
													
													
			String[] title = new String[size]; 
			title = cartReadertitle(size); 
											
			String[] type = new String[size]; 
			int[] fullprice = new int[size]; 
			int environmenttax = 0; 
									
			int hst = 0; 
			int shipcost = 0; 
			int finalprice = 0; 
			int[] ibprice = new int[size]; 
			System.out.println("Billing Information:"); 
														
														
			System.out.println("Name\t\t\t\tQuantity\t\t\tPrice\n"); 
																		
																		
																		
																		
																		
			for (int i = 0; i < num.length; i++) { 
													
													
													
													
				System.out.printf("%-35s %-30s %3s %n", title[i], quantity[i], findsprice(num[i])); 
																									
																									
																									
																									
																									
				
				
			} 
			for (int k = 0; k < num.length; k++) { 
													
													
													
				fullprice[k] = findsprice(num[k]) * quantity[k]; 
																	
																	
				ibprice[k] = fullprice[k]; 
											
			} 
			for (int j = 0; j < fullprice.length; j++) { 
															
															
															
															
															
				if (findstype(num[j]) == "Book" || findstype(num[j]) == "CD") { 
																				
																				
																				
																				
																				
																				
					environmenttax += fullprice[j] * 0.02; 
															
					shipcost += fullprice[j] * 0.10; 
					ibprice[j] = (int) (fullprice[j] * 1.12); 
																
																
																
																
				}
			} 
			System.out.printf("%-35s %-30s %3s %n", "\nEnvironement Tax", "2%", environmenttax); 
																									
																									
																									
																									
			for (int j = 0; j < fullprice.length; j++) { 
															
															
				hst += fullprice[j] * 0.13; 
				ibprice[j] += (int) (fullprice[j] * 0.13); 
			} 
				
			System.out.printf("%-34s %-30s %3s %n", "HST", "13%", hst); 
																		
																		
																		
																		
			
			
			System.out.printf("%-34s %-30s %3s %n", "Shipping", "10%", shipcost); 
																					
																					
																					
																					
			for (int j = 0; j < fullprice.length; j++) { 
															
															
				finalprice += fullprice[j]; 
			} 
			finalprice += shipcost + hst + environmenttax; 
															
			
			
			System.out.printf("%-35s %-30s %3s %n", "\nTotal", "", finalprice + "$" + "\n"); 
																								
																								
																								
																								
			Scanner scan = new Scanner(System.in); 
													
			System.out.print("Are you sure you want to pay? "); 
																
			String toPay = scan.next(); 
			if (toPay.equals("yes") || toPay.equals("Yes") || toPay.equals("yeS") || toPay.equals("YES")
					|| toPay.equals("YeS") || toPay.equals("y") || toPay.equals("Y")) { 
																						
																						
																						
																						
																						
																						
																						
																						
																						
				for (int j = 0; j < num.length; j++) { 
														
					if (findstype(num[j]) != "MP3") { 
						housekeeping(num[j], quantity[j], findstype(num[j])); 
																				
																				
																				
					} else { 
						housekeepingmp3(num[j], quantity[j], findstype(num[j])); 
																					
																					
																					
																					
					} 
				} 
				System.out.println("Confirmation ID: " + confcode()); 
																		
																		
																		
																		
				System.out.println("Items Shipped to: Mr." + holder); 
																		
																		
																		
																		
				String confirmationcode = confcode(); 
														
														
				for (int k = 0; k < num.length; k++) { 
														
														
					createItemsbought(holder, confirmationcode, title[k], ibprice[k]); 
																						
																						
																						
																						
																						
																						
					
				} 
				deletecartcontents(num); 
			} else if ((toPay.equals("no") || toPay.equals("No") || toPay.equals("nO") || toPay.equals("NO")
					|| toPay.equals("N") || toPay.equals("n"))) { 
																	
																	
																	
																	
																	
				UserInterface ui = new UserInterface(); 
				ui.changeCurrentPage(5); 
				System.out.printf("%-35s %-30s %3s %n", "Shipping", "10%", shipcost); 
																						
																						
																						
																						
			} 
		} catch (InputMismatchException e) { 
												
			System.out.println("Input Error"); 
		}

	} 

	public static String confcode() { 
										
		File f = new File("ItemBought.txt"); 
		if (f.exists()) { 
			int ibsizeoffile = ibsize(); 
			String[] array = findItemBought(ibsizeoffile); 
															
			String U = "U"; 
			int confirmationnum = Integer.parseInt(array[ibsizeoffile - 1].substring(1)); 
																							
																							
																							
																							
																							
																							
																							
																							
			confirmationnum += 1; 
			String confirmationcode = U + confirmationnum; 
															
															
			return confirmationcode; 
		} else { 
			return "U1000"; 
		} 
	} 

	public static int ibsize() { 
		try { 
			Scanner sc = new Scanner(new File("ItemBought.txt")); 
			String[] arr = new String[8]; 
			int i = 0; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				i++; 
			} 
			sc.close(); 
			return i; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return 0; 
	} 

	public static String[] findItemBought(int i) { 
		try { 
			Scanner sc = new Scanner(new File("ItemBought.txt")); 
																	
			String[] arr = new String[8]; 
			String num[] = new String[i]; 
			int j = 0; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				num[j] = arr[1]; 
									
				j++; 
			} 
			return num; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) {
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static void createItemsbought(String User, String Confirmation, String Title, int Price) {
		File f = new File("ItemBought.txt"); 
		try { 
			if (f.exists()) { 
				String filename = "ItemBought.txt"; 
													
				FileWriter fw = new FileWriter(filename, true); 
				fw.write(User + "," + Confirmation + "," + Title + "," + Price + "\r\n");
																							
																							
																							
																							
																							
				
				fw.close(); 

			} else { 
				PrintWriter toWrite = new PrintWriter("ItemBought.txt", "UTF-8"); 
																					
																					
				toWrite.println(User + "," + Confirmation + "," + Title + "," + Price); 
																						
																						
																						
				toWrite.close(); 
				
			}
		} catch (IOException ioe) { 
			System.out.println("Exception caught!"); 
			ioe.printStackTrace(); 
		} 
	} 

	public static void deletecartcontents(int[] sN0) {
		try { 
			FileOutputStream fos = null; 
			fos = new FileOutputStream("Cart_" + holder + ".txt"); 
			fos.close(); 
			deletercontents(); 
		} catch (Exception ex) { 
			System.out.print("IOException: File output stream is closed"); 
																			
		} 

	} 

	public static void deletercontents() {

		File file = new File("Cart_" + holder + ".txt"); 
		file.setWritable(true); 
		file.delete(); 
	} 

	public static String[] writtercontents(int[] sNO) {
		try { 
			PrintWriter toWrite = new PrintWriter("Cart_" + holder + ".txt", "UTF-8"); 
																						
																						
																						
																						
			for (int i = 0; i < sNO.length; i++) { 
													
													
				toWrite.println(""); 
			} 
			toWrite.close(); 
		} catch (IOException ioe) { 
			System.out.println("Exception caught!"); 
			ioe.printStackTrace(); 
		} 
		String[] emp = new String[1]; 
		emp[0] = " "; 
		return emp; 
	} 

	public static int[] cartReadersNO(int size) { 
													

		try { 
			Scanner sc = new Scanner(new File("Cart_" + holder + ".txt")); 
																			
																			
																			
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[size]; 
			String[] title = new String[100]; 
			String[] type = new String[100]; 
			int price[] = new int[100]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
				i++;
			} 
			for (int j = 0; j < i; j++) { 
											
				return num; 
			} 
			sc.close(); 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static int[] cartReaderquantity(int size) { 
														
														

		try { 
			Scanner sc = new Scanner(new File("Cart_" + holder + ".txt")); 
																			
																			
																			
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[size]; 
										
			int quantity[] = new int[size]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
													
				quantity[i] = Integer.parseInt(arr[3]); 
														
														
				i++; 
			} 
			for (int j = 0; j < i; j++) { 
											
				return quantity; 
			} 
			sc.close(); 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static String[] cartReadertitle(int size) {
		try { 
			Scanner sc = new Scanner(new File("Cart_" + holder + ".txt")); 
																			
																			
																			
																			
																			
			String[] arr = new String[8]; 
											
			int i = 0; 
			String title[] = new String[size]; 
												
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				title[i] = arr[1]; 
									
				i++; 
			} 
			for (int j = 0; j < i; j++) { 
											
				return title; 
			} 
			sc.close(); 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
									
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static int cartReadersize() {

		try { 
			Scanner sc = new Scanner(new File("Cart_" + holder + ".txt")); 
																			
																			
																			
																			
																			
																			
																			
																			
																			
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[100]; 
										
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
				i++; 
			} 
			sc.close(); 
			return i; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace();
		} 
		return 0; 
	} 

	public static int findsprice(int input) {
		try {
			Scanner sc = new Scanner(new File("CDs.txt")); 
															
			Scanner sc1 = new Scanner(new File("MP3.txt")); 
															
			Scanner sc2 = new Scanner(new File("Books.txt")); 
																
			Scanner sc3 = new Scanner(new File("Ebooks.txt")); 
																
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[100]; 
			String[] title = new String[100]; 
			String[] type = new String[100]; 
			int price[] = new int[100]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
				arr = readLine.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				title[i] = arr[1]; 
				price[i] = Integer.parseInt(arr[3]); 
														
				type[i] = "CDs"; 
				i++; 
			} 
			while (sc1.hasNextLine()) { 
				String read = sc1.nextLine(); 
				arr = read.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				title[i] = arr[1]; 
				price[i] = Integer.parseInt(arr[3]); 
														
				type[i] = "MP3s"; 
				i++; 
			} 
			while (sc2.hasNextLine()) { 
				String readLine = sc2.nextLine(); 
				arr = readLine.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				title[i] = arr[1]; 
				price[i] = Integer.parseInt(arr[3]); 
														
				type[i] = "Books"; 
				i++; 
			} 
			while (sc3.hasNextLine()) { 
				String read = sc3.nextLine(); 
				arr = read.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				title[i] = arr[1]; 
				price[i] = Integer.parseInt(arr[3]); 
														
				type[i] = "Ebooks"; 
				i++; 
			} 
			for (int j = 0; j < i; j++) { 
											
				if (num[j] == input) { 
					return price[j]; 
				} 
			} 
			sc.close(); 
			sc1.close(); 
			sc2.close(); 
			sc3.close(); 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
														
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return 0; 
	} 

	public static String findstype(int input) {
		try { 
			Scanner sc = new Scanner(new File("CDs.txt")); 
															
			Scanner sc1 = new Scanner(new File("MP3.txt")); 
															
			Scanner sc2 = new Scanner(new File("Books.txt")); 
																
			Scanner sc3 = new Scanner(new File("Ebooks.txt")); 
																
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[100]; 
			String[] type = new String[100]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
				arr = readLine.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				type[i] = "CD"; 
				i++; 
			} 
			while (sc1.hasNextLine()) { 
				String read = sc1.nextLine(); 
				arr = read.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				type[i] = "MP3"; 
				i++; 
			} 
			while (sc2.hasNextLine()) { 
				String readLine = sc2.nextLine(); 
				arr = readLine.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				type[i] = "Book"; 
				i++; 
			} 
			while (sc3.hasNextLine()) { 
				String read = sc3.nextLine(); 
				arr = read.split(",\\s*"); 
				num[i] = Integer.parseInt(arr[0]); 
				type[i] = "Ebook"; 
				i++; 
			} 
			for (int j = 0; j < i; j++) { 
											
				if (num[j] == input) { 
					return type[j]; 
				} 
			} 
			sc.close(); 
			sc1.close(); 
			sc2.close(); 
			sc3.close(); 

		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
														
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static void housekeeping(int n, int quant, String s) {

		int size = length(s); 
		int[] num = new int[size]; 
									
		num = sNO(size, s); 
		String[] title = new String[size]; 
		title = gettitle(size, s); 
									
		String[] author = new String[size]; 
		author = getauthor(size, s); 
										
		int[] price = new int[size]; 
		price = getprice(size, s); 
									
		int[] quantity = new int[size]; 
		quantity = getquantity(size, s); 
											
		for (int i = 0; i < size; i++) { 
											
			if (num[i] == n) { 
				quantity[i] = quantity[i] - quant; 
													
			} 
		} 
		deleter(s); 
		writter(s, num, title, author, price, quantity); 
															
	}

	public static void deleter(String type) { 
		File file = new File("" + type + "s" + ".txt"); 
		boolean status = file.delete(); 
	}

	public static String[] writter(String type, int[] sNO, String[] title, String[] author, int[] price,
			int[] quantity) {
		try { 
			PrintWriter toWrite = new PrintWriter(type + "s" + ".txt", "UTF-8"); 
																					
																					
			for (int i = 0; i < sNO.length; i++) { 
													
				toWrite.println(sNO[i] + ", " + title[i] + ", " + author[i] + ", " + price[i] + ", " + quantity[i]); 
																														
																														
			} 
			toWrite.close(); 
		} catch (IOException ioe) { 
			System.out.println("Exception caught!"); 
			ioe.printStackTrace(); 
		} 
		String[] emp = new String[1]; 
										
		emp[0] = " "; 
		return emp; 
	} 

	public static int length(String type) {
		try { 
			Scanner sc = new Scanner(new File(type + "s" + ".txt")); 
																		
																		
			String[] arr = new String[8]; 
			int i = 0; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
				arr = readLine.split(",\\s*"); 
												
				i++; 
			} 
			sc.close(); 
			return i; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return 0; 
	} 

	public static int[] sNO(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + "s" + ".txt")); 
																		
																		
																		
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[size]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
													
				i++; 
			} 
			sc.close(); 
			return num; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static String[] gettitle(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + "s" + ".txt"));
																	
																	
			String[] arr = new String[8]; 
			int i = 0; 
			String title[] = new String[size]; 
												
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				title[i] = arr[1]; 
				i++; 
			} 
			sc.close(); 
			return title; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static String[] getauthor(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + "s" + ".txt")); 
																		
																		
			String[] arr = new String[8]; 
			int i = 0; 
			String author[] = new String[size]; 
												
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				author[i] = arr[2]; 
				i++; 
			} 
			sc.close(); 
			return author; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static int[] getprice(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + "s" + ".txt")); 
																		
																		
			String[] arr = new String[8]; 
			int i = 0; 
			int price[] = new int[size]; 
											
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				price[i] = Integer.parseInt(arr[3]); 
														
				i++; 
			} 
			sc.close(); 
			return price; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static int[] getquantity(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + "s" + ".txt")); 
																		
			String[] arr = new String[8]; 
			int i = 0; 
			int quantity[] = new int[size]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				quantity[i] = Integer.parseInt(arr[4]); 
														
														
				i++; 
			} 
			sc.close(); 
			return quantity; 
		} catch (FileNotFoundException fnfe) { 
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
									
			ioe.printStackTrace();
		} 
		return null; 
	} 

	public static void housekeepingmp3(int n, int quant, String s) { 
																		
																		
																		
																		
																		

		int size = lengthmp3(s); 
									
		int[] num = new int[size]; 
		num = sNOmp3(size, s); 
		String[] title = new String[size]; 
											
		title = gettitlemp3(size, s); 
		String[] author = new String[size]; 
											
		author = getauthormp3(size, s); 
										
		int[] price = new int[size]; 
		price = getpricemp3(size, s); 
										
		int[] quantity = new int[size]; 
		quantity = getquantitymp3(size, s); 
		for (int i = 0; i < size; i++) { 
											
			if (num[i] == n) { 
				quantity[i] = quantity[i] - quant; 
													
													
			} 
				
				
				
		} 
		deletermp3(s); 
		writtermp3(s, num, title, author, price, quantity); 
															
															
															
	} 

	public static void deletermp3(String type) {
		File file = new File(type + ".txt"); 

		boolean status = file.delete(); 
		
		
		
		
		
		
		

	} 

	public static String[] writtermp3(String type, int[] sNO, String[] title, String[] author, int[] price,
			int[] quantity) {
		try { 
			PrintWriter toWrite = new PrintWriter(type + ".txt", "UTF-8"); 
																			
																			
																			
			for (int i = 0; i < sNO.length; i++) { 
													
				toWrite.println(sNO[i] + ", " + title[i] + ", " + author[i] + ", " + price[i] + ", " + quantity[i]); 
																														
																														
																														
																														
			} 
			toWrite.close(); 
		} catch (IOException ioe) { 
			System.out.println("Exception caught!"); 
			ioe.printStackTrace(); 
		} 
		String[] emp = new String[1]; 
										
		emp[0] = " "; 
		return emp; 
					
	} 

	public static int lengthmp3(String type) {
		try { 
			Scanner sc = new Scanner(new File(type + ".txt")); 
																
			String[] arr = new String[8]; 
			int i = 0; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				i++; 
			} 
			sc.close(); 
			return i; 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return 0; 
	} 

	public static int[] sNOmp3(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + ".txt")); 
																
																
			String[] arr = new String[8]; 
			int i = 0; 
			int num[] = new int[size]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				num[i] = Integer.parseInt(arr[0]); 
													
													
				i++; 
			} 
			sc.close(); 
			return num; 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static String[] gettitlemp3(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + ".txt")); 
																
			String[] arr = new String[8]; 
			int i = 0; 
			String title[] = new String[size]; 
												
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
				arr = readLine.split(",\\s*"); 
												
				title[i] = arr[1]; 
				i++; 
			} 
			sc.close(); 
			return title; 
		} catch (FileNotFoundException fnfe) { 
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 
		return null; 
	} 

	public static String[] getauthormp3(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + ".txt")); 
																
																
			String[] arr = new String[8]; 
			int i = 0; 
			String author[] = new String[size]; 
												
			while (sc.hasNextLine()) { 
										
				String readLine = sc.nextLine();
												
				arr = readLine.split(",\\s*"); 
												
												
												
				author[i] = arr[2]; 
				i++;
			} 
			sc.close();
			return author; 
		} catch (FileNotFoundException fnfe) {
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) {
			ioe.printStackTrace();
		} 
		return null; 
	} 

	public static int[] getpricemp3(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + ".txt")); 
																
																
			String[] arr = new String[8]; 
			int i = 0; 
			int price[] = new int[size]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine();
												
				arr = readLine.split(",\\s*"); 
												
												
												
				price[i] = Integer.parseInt(arr[3]); 
														
														
														
				i++;
			} 
			sc.close();
			return price; 
		} catch (FileNotFoundException fnfe) {
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) {
			ioe.printStackTrace();
		} 
		return null; 
	} 

	public static int[] getquantitymp3(int size, String type) {
		try { 
			Scanner sc = new Scanner(new File(type + ".txt")); 
																
																
																
			String[] arr = new String[8]; 
											
			int i = 0; 
			int quantity[] = new int[size]; 
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine();
												
				arr = readLine.split(",\\s*"); 
												
				quantity[i] = Integer.parseInt(arr[4]);
				i++;
			}
			sc.close();
			return quantity;

		} catch (NumberFormatException nfe) {
			Scanner sc; 
			try { 
				sc = new Scanner(new File(type + ".txt")); 
															
															
															
				String readLine = sc.nextLine();
												
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find file!"); 
			}

		} catch (FileNotFoundException fnfe) {
												
			System.out.println("Unable to find file!"); 
		} catch (Exception ioe) {
			ioe.printStackTrace();
									
		} 
		return null; 
	} 

	public static void P11() {
		System.out.println("Confirmation ID" + "\t\t\t" + "Product Name" + "\t\t\t" + "Total"); 
																								
																								
																								
																								
																								
		printP11(holder); 
							
	} 

	public static String printP11(String user) {
		try { 
			Scanner sc = new Scanner(new File("ItemBought.txt")); 
																	
																	
			String[] arr = new String[8]; 
											
			int i = 0; 
			String name[] = new String[ibsize()]; 
													
													
			String[] confirmation = new String[ibsize()]; 
															
			String[] title = new String[ibsize()]; 
													
			String[] total = new String[ibsize()]; 
													
			while (sc.hasNextLine()) { 
				String readLine = sc.nextLine(); 
													
													
													
				arr = readLine.split(",\\s*"); 
												
												
												
				name[i] = arr[0]; 
									
				confirmation[i] = arr[1]; 
											
											
				title[i] = arr[2]; 
									
				total[i] = arr[3]; 
									
				i++; 

			} 
			for (int j = 0; j < i; j++) { 
											
											
											
				if (name[j].equals(user)) { 
					System.out.printf("%-30s %-27s %10s %n", confirmation[j], title[j], total[j]); 
																									
																									
																									
																									
				} 
			} 
			System.out.print("\nPress -1 to return to previous menu: "); 
																			
			Scanner sc2 = new Scanner(System.in); 
													
			UserInterface ui = new UserInterface(); 
			int inputToContinue = sc2.nextInt(); 
													
			if (inputToContinue == -1) { 
				ui.changeCurrentPage(5); 
			}
			else{
				System.out.println("Input Error");
				UserInterface ui1 = new UserInterface();
				ui1.changeCurrentPage(11)	;
				
			}
			sc.close();
		} catch (FileNotFoundException fnfe) { 
												
												
			System.out.println("Unable to find file!"); 
														
		} catch (IOException ioe) { 
			System.out.println("Input Error");
			
												
												
		} 
		return "Error finding type"; 
	} 
} 
