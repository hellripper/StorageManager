/**
 * 
 */
package inputprocessor;

import datastore.DS2;
import driver.TestDriver;
import mdaefsm.MDAEFSM;

/**
 * @author PenchalaSainath
 *
 */
public class Account2 {
	public MDAEFSM m;
	public DS2 ds2;
	
	public static int maxAtt=2;	//maximum attempts that can be made
	public static int minBal=500;	//minimum balance that required
//	public static int penalty=20;	//penalty when balance is below the minimum balance
	
	public Account2(){
		m=new MDAEFSM();
		ds2=new DS2();
	}
	
	// OPEN
	public void OPEN(int p, int y, int a){
		TestDriver.a2p = p;
		TestDriver.a2y = y;
		TestDriver.a2a = a;
		
		m.Open();
	}
	//PIN
	public void PIN(int x){
		ds2=TestDriver.ds2;
		if(x==ds2.pin){
			if(ds2.bal == 0){
				m.CorrectPinBelowMin();
				m.NoFunds();
			}else{
				m.CorrectPinAboveMin();
			}
		}else{
			m.IncorrectPin(2);
		}
	}
	
	//DEPOSIT
	public void DEPOSIT(int d){
		TestDriver.tempa2Deposit=d;//store d in temp data store;
		ds2=TestDriver.ds2;
		m.Deposit();
	}
	
	//BALANCE
	public void BALANCE(){
		m.Balance();
	}
	
	// LOGIN
	public void LOGIN( int account){
		ds2 = TestDriver.ds2;
		if(account == ds2.account){
			m.Login();
		}else{
			m.IncorrectLogin();
		}
	}
	
	//WITHDRAW
	public void WITHDRAW(int w){
		TestDriver.tempa2Withdraw=w;//store w in temp data store;
		ds2=TestDriver.ds2;
		if(ds2.bal-w > 0){
			m.Withdraw();
		}else{
			m.NoFunds();
		}
	}
	
	// LOGOUT
	public void LOGOUT(){
		m.Logout();
	}
	
	//Suspend
	public void suspend(){
		m.Suspend();
	}
	
	//activate
	public void activate(){
		m.Activate();
	}
	
	//close
	public void close(){
		m.Close();
	}
}
