package strategy.makepenalty;

import driver.TestDriver;
import inputprocessor.Account1;

//This class is a part of Strategy Pattern.
//This class is used to perform the penalty action when using ATM1.
public class MakePenalty1 implements MakePenalty{
	public void makePenalty(){
		TestDriver.ds1.bal-=Account1.penalty;
	}
}
