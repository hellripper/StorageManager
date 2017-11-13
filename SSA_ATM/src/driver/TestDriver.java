package driver;
import inputprocessor.Account1;
import inputprocessor.Account2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import abstractfactory.AF;
import abstractfactory.CF1;
import abstractfactory.CF2;

import datastore.DS1;
import datastore.DS2;


//This class is design to test the MDA-EFSM architecture.
public class TestDriver {

	private static Scanner input=new Scanner(System.in);
	private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	//Abstract Factory
	public static AF factory;
	
	public static DS1 ds1;	//DataStore for Account1
	public static DS2 ds2;	//DataStore for Account2
	
	//Temp Data for Account1
	public static String a1p;
	public static String a1y;
	public static float a1a;
	public static float tempa1Deposit;
	public static float tempa1Withdraw;
	
	//Temp Data for Account2
	public static int a2p;
	public static int a2y;
	public static int a2a;
	public static int tempa2Deposit;
	public static int tempa2Withdraw;
	
	public static void pauseProg() {// pause function to pause the program
		System.out.println("    Press enter to continue...");
		input.nextLine();
	}
	
	//clear the screen
	public static void clearScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static void main(String[] args) throws IOException {

		System.out.println("\n\n\n\n\n\n\n\n								CS  586							");
		System.out.println("								PROJECT							");
		System.out.println("							 	  DEMO							");

//		System.out.println("\n\n\n\n\n\n\nNOTE: this is the full version implementation!\n\n\n\n\n\n\n");
		pauseProg();

			clearScreen();
			System.out.println("\n\n\n\n\n\n\n\n\n								Select Account 1, Account 2 \n\n");
			System.out.println("		1. Account 1");
			System.out.println("		2. Account 2");
			
			System.out.println("	Select Account:");
			
			//select the Account: 1-Account 1, 2-Account 2
			int selectAccount = input.nextInt();
			switch (selectAccount) {
			// if selected account 1
				case 1: {
					factory=new CF1();	//ConcreteFactory for Account 1
					Account1 Account1=new Account1();
					ds1=new DS1();
					
					float balance;
					String pin;
					String account;
					float amount;
					
					clearScreen();
					// List of menu Operations
					System.out.println("\n\n\n\n\n\n\n					Account-1");
					System.out.println("				MENU of Operations");
					System.out.println("		0. open(String p, String y, int a)");
					System.out.println("        1. login(String y)");
					System.out.println("		2. pin(int x)");
					System.out.println("		3. deposit(float d)");
					System.out.println("		4. withdraw(float w)");
					System.out.println("		5. balance()");
					System.out.println("		6. lock(String x)");
					System.out.println("		7. unlock(String x)");
					System.out.println("		8. logout()");
					System.out.println("		23. Quit the demo program\n\n");
	
					System.out.println("	Account-1 Execution\n");
					
					//select the action
					int operation = 0;
					while (operation != 23) {
						System.out.println("  Select Operation:");
						System.out.println("0- open, 1-login,2-pin,3-deposit,4-withdraw,5-balance,6-lock,7-unlock,8-logout,23-exit\n");
						operation = input.nextInt();
						
						switch (operation) {
						// open
						case 0:
							System.out.println("  Operation: open(String p, String y, float a)");
							System.out.println("  Enter the value of parameter p");
							pin = br.readLine();
							System.out.println("  Enter the value of parameter y");
							account = br.readLine();
							System.out.println("  Enter the value of parameter a");
							balance = input.nextFloat();
							
							Account1.open(pin, account, balance);
							break;
						// login
						case 1:
							System.out.println("  Operation: login(String y)");
							System.out.println("  Enter value of the parameter x:");
							account = br.readLine();
							
							Account1.login(account);
							break;
						//pin
						case 2:
							System.out.println("  Operation: pin(String x)");
							System.out.println("  Enter value of the parameter x:");
							pin = br.readLine();
							Account1.pin(pin);
							break;
						//deposit
						case 3:
							System.out.println("  Operation: deposit(float d)");
							System.out.println("  Enter value of the parameter d:");
							amount = input.nextFloat();
							
							Account1.deposit(amount);
							break;
						//withdraw
						case 4:
							System.out.println("  Operation: withdraw(int w)");
							System.out.println("  Enter value of the parameter w:");
							amount = input.nextFloat();
							
							Account1.withdraw(amount);
							break;
						//balance
						case 5:
							System.out.println("  Operation: balance()");
							Account1.balance();
							break;
						//lock
						case 6:
							System.out.println("  Operation: lock(String x)");
							System.out.println("  Enter value of the parameter x:");
							pin = br.readLine();
							
							Account1.lock(pin);
							break;
						//unlock
						case 7:
							System.out.println("  Operation: unlock(String x)");
							System.out.println("  Enter value of the parameter x:");
							pin = br.readLine();
							
							Account1.unlock(pin);
							break;
						//logout
						case 8:
							System.out.println("  Opeartion: logout()");
							
							Account1.logout();

						default:
							break;
						}						
					}
					break;
				}
				
				// if selected account 2
				case 2: {
					factory = new CF2();	//ConcreteFactory for Account2
					Account2 Account2 = new Account2();
					ds2 = new DS2();
					
					int balance;
					int pin;
					int account;
					int amount;
					
					clearScreen();
					// displaying list of menu operations
					System.out.println("\n\n\n\n\n\n\n					Account-2");
					System.out.println("Menu of operations");
					System.out.println("0. OPEN(int,int,int)");
					System.out.println("1. LOGIN(int)");
					System.out.println("2. PIN(int)");
					System.out.println("3. DEPOSIT(int)");
					System.out.println("4. WITHDRAW(int)");
					System.out.println("5. BALANCE()");
					System.out.println("6. LOGOUT()");
					System.out.println("7. suspend()");
					System.out.println("8. activate()");
					System.out.println("9. close()");
					System.out.println("23. Quit the demo program");
					System.out.println("");
					System.out.println("Please make a note of these operations");

					System.out.println("	Account-2 Execution\n");
					//Select operation
					int operation = 0;
					while (operation != 23) {
						System.out.println("  Select Operation:");
						System.out.println(
								"0. OPEN,1. LOGIN,2. PIN,3. DEPOSIT,4. WITHDRAW,5. BALANCE,6. LOGOUT,7. suspend,8. activate,9. close");	
						operation = input.nextInt();
						
						switch (operation) {
						//OPEN
						case 0:
							System.out.println("Operation: OPEN int p, int y, int a ");
							System.out.println("Enter the value of parameter p");
							pin = input.nextInt();
							System.out.println("Enter the value of parameter y");
							account = input.nextInt();
							System.out.println("Enter the value of paramenter a");
							balance = input.nextInt();

							// call the appropriate function
							Account2.OPEN(pin, account, balance);
							break;

						// LOGIN
						case 1: 
							System.out.println("Operation: LOGIN(int y)");
							System.out.println("Enter the value for parameter y");
							account = input.nextInt();

							// call the appropriate function
							Account2.LOGIN(account);
							break;

						// PIN
						case 2:
							System.out.println("Operation: PIN(int x)");
							System.out.println("Enter the value for parameter x");
							pin = input.nextInt();

							// call the appropriate function
							Account2.PIN(pin);
							break;

						// DEPOSIT
						case 3:
							System.out.println("Operation: DEPOSIT(int d)");
							System.out.println("Enter the value for parameter d");
							amount = input.nextInt(); 

							// call the appropriate function
							Account2.DEPOSIT(amount);
							break;

						// WITHDRAW
						case 4:
							System.out.println("Operation: WITHDRAW(int w)");
							System.out.println("Enter the value for parameter w");
							amount = input.nextInt(); 

							// call the appropriate function
							Account2.WITHDRAW(amount);
							break;

						// BALANCE
						case 5:
							System.out.println("Operation: BALANCE()");
							// call the appropriate function
							Account2.BALANCE();
							break;
							
						// LOGOUT
						case 6:
							System.out.println("Opeartion: LOGOUT()");
							// call the appropriate function
							Account2.LOGOUT();
							break;

						// suspend
						case 7:
							System.out.println("Operation: suspend()");
							// call the appropriate function
							Account2.suspend();
							break;
							
						// activate
						case 8:
							System.out.println("Operation: activate()");
							// call the appropriate function
							Account2.activate();
							break;
						
						// close
						case 9:
							System.out.println("Operation: close()");
							// call the appropriate function
							Account2.close();
							break;
						
						// default
						default:
							// handling other inputs
							break;
					}
				}
			}
		}
	}
}
