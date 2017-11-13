package strategy.displaybal;

import driver.TestDriver;

//This class is a part of Strategy Pattern.
//This class is used to perform the displayBal action when using ATM1.
public class DisplayBal1 implements DisplayBal{
	public void displayBal(){
		System.out.println("\n  CURRENT BALANCE: $"+TestDriver.ds1.bal);
	}
}
