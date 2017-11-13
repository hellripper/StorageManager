package strategy.makedeposit;

import driver.TestDriver;

//This class is a part of Strategy Pattern.
//This class is used to perform the deposit action when using ATM1.
public class MakeDeposit1 implements MakeDeposit{
	public void makeDeposit(){
		TestDriver.ds1.bal+=TestDriver.tempa1Deposit;
	}
}
