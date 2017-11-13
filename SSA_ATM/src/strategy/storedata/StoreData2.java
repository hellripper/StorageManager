package strategy.storedata;

import driver.TestDriver;

public class StoreData2 implements StoreData {
	@Override
	public void storeData() {
		// TODO Auto-generated method stub
		TestDriver.ds2.pin = TestDriver.a2p;
		TestDriver.ds2.account = TestDriver.a2y;
		TestDriver.ds2.bal = TestDriver.a2a;
	}
}
