package strategy.displaymenu;

//This class is a part of Strategy Pattern.
//This class is used to perform the displayMenu action when using ATM2.
public class DisplayMenu2 implements DisplayMenu{
	public void displayMenu() {
		System.out.println("\n\n	TRANSACTION MENU:");
		System.out.println("		DEPOSIT");
		System.out.println("		WITHDRAW");
		System.out.println("		BALANCE\n");
		System.out.println("		LOGOUT\n");
		System.out.println("		suspend\n");
		System.out.println("		activate\n");
		System.out.println("		close\n");
	}
}
