package strategy.makedeposit;

import driver.TestDriver;

//This class is a part of Strategy Pattern.
//This class is used to perform the deposit action when using ATM2.
public class MakeDeposit2 implements MakeDeposit{
	public void makeDeposit(){
		TestDriver.ds2.bal+=TestDriver.tempa1Deposit;
	}
}
