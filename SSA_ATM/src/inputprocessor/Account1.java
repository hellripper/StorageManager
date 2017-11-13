/**
 * 
 */
package inputprocessor;

import datastore.DS1;
import driver.TestDriver;
import mdaefsm.MDAEFSM;

/**
 * @author PenchalaSainath
 *
 */
public class Account1 {
	public MDAEFSM m;
	public DS1 ds1;
	
	public static int maxAtt=3;	//maximum attempts that can be made
	public static int minBal=500;	//minimum balance that required
	public static int penalty=20;	//penalty when balance is below the minimum balance
	
	public Account1(){
		m=new MDAEFSM();
		ds1=new DS1();
	}
	
	public void open(String p, String y, float a){
		TestDriver.a1p = p;
		TestDriver.a1y = y;
		TestDriver.a1a = a;
		
		m.Open();
	}
	
	//pin
	public void pin(String x){
		ds1=TestDriver.ds1;
		if(x.equals(ds1.pin)){
			if(ds1.bal<500)
				m.CorrectPinBelowMin();
			else
				m.CorrectPinAboveMin();
		}else{
			m.IncorrectPin(3);
		}
	}

	//deposit
	public void deposit(float d){
		TestDriver.tempa1Deposit=d;//store d in temp data store;
		ds1=TestDriver.ds1;
		m.Deposit();
		if(ds1.bal<500) 
			m.BelowMinBalance();
		else 
			m.AboveMinBalance();
	}
	//withdraw
	public void withdraw(float w){
		TestDriver.tempa1Withdraw=w;//store w in temp data store;
		ds1=TestDriver.ds1;
		m.Withdraw();
		if(ds1.bal > 500)
			m.AboveMinBalance();
		else 
			m.WithdrawBelowMinBalance();
	}
	//balance
	public void balance(){
		m.Balance();
	}
	
	// login
	public void login(String y){
		ds1 = TestDriver.ds1;
		String account = ds1.account;
		if(y.equals(account)){
			m.Login();
		}else{
			m.IncorrectLogin();
		}
	}
	
	//lock
	public void lock(String x){
		ds1=TestDriver.ds1;
		if(x.equals(ds1.pin))
			m.Lock();
		else 
			m.IncorrectLock();
	}
	//unlock
	public void unlock(String x){
		ds1=TestDriver.ds1;
		if(x.equals(ds1.pin)){
			if(ds1.bal < 500)
				m.BelowMinBalance();
			else 
				m.AboveMinBalance();
		}else{
			m.IncorrectUnlock();
		}
	}
	
	// logout
	public void logout(){
		m.Logout();
	}
}
