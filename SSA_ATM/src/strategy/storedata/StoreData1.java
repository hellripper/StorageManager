package strategy.storedata;

import driver.TestDriver;

public class StoreData1 implements StoreData {

	@Override
	public void storeData() {
		// TODO Auto-generated method stub
		TestDriver.ds1.pin = TestDriver.a1p;
		TestDriver.ds1.account = TestDriver.a1y;
		TestDriver.ds1.bal = TestDriver.a1a;
	}

}
