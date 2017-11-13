package strategy.makewithdraw;

import driver.TestDriver;

//This class is a part of Strategy Pattern.
//This class is used to perform the withdraw action when using ATM1.
public class MakeWithdraw1 implements MakeWithdraw{
	public void makeWithdraw(){
		TestDriver.ds1.bal-=TestDriver.tempa1Withdraw;
	}
}
