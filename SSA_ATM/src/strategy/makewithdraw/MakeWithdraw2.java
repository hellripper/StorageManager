package strategy.makewithdraw;

import driver.TestDriver;

//This class is a part of Strategy Pattern.
//This class is used to perform the withdraw action when using ATM2.
public class MakeWithdraw2 implements MakeWithdraw{
	public void makeWithdraw(){
		TestDriver.ds2.bal-=TestDriver.tempa2Withdraw;
	}
}
