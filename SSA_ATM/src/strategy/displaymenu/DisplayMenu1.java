package strategy.displaymenu;

//This class is a part of Strategy Pattern.
//This class is used to perform the displayMenu action when using ATM1 and ATM3.
public class DisplayMenu1 implements DisplayMenu {
	public void displayMenu() {
		System.out.println("\n\n	TRANSACTION MENU:");
		System.out.println("		DEPOSIT");
		System.out.println("		WITHDRAW");
		System.out.println("		BALANCE");
		System.out.println("		LOCK");
		System.out.println("		UNLOCK\n");
	}
}
