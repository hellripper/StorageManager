package mdaefsm;

import state.CheckPin;
import state.Close;
import state.Idle;
import state.Locked;
import state.Overdrawn;
import state.Ready;
import state.S1;
import state.Start;
import state.State;
import state.Suspend;

//This class is design for the MDA-EFSM Model

// This class is also a context class as a part of State Pattern.
public class MDAEFSM {
	//LS[0]: object of "Start" state
	//LS[1]: object of "Idle" state
	//LS[2]: object of "CheckPin" state
	//LS[3]: object of "Ready" state
	//LS[4]: object of "S1" state
	//LS[5]: object of "Overdrawn" state
	//LS[6]: object of "Locked" state
	//LS[7]: object of "Suspend" state
	//LS[8]: object of "Close" state
	private State[] LS=new State[9];
	private State s;	//current state
	private int attempts;	//platform independent data
	
	public MDAEFSM(){
		LS[0]=new Start(this);
		LS[1]=new Idle(this);
		LS[2]=new CheckPin(this);
		LS[3]=new Ready(this);
		LS[4]=new S1(this);
		LS[5]=new Overdrawn(this);
		LS[6]=new Locked(this);
		LS[7]=new Suspend(this);
		LS[8]=new Close(this);
		s=new Start(this);
	}
	//change the current state
	public void changeState(int x){
		s=LS[x];
	}
	
	// returns attempts made
	public int getAttempts(){
		return attempts;
	}
	
	// initializes the attempts
	public void setAttempts(int x){
		attempts=x;
	}
	
	// open
	public void Open(){
		s.Open();
	}
	
	//create
	public void Login(){
		s.Login();
	}
	//card
	public void IncorrectLogin(){
		s.IncorrectLogin();
	}
	//incorrectPin
	public void IncorrectPin(int max){
		s.IncorectPin(max);
	}
	//correctPinAboveMin
	public void CorrectPinAboveMin(){
		s.CorrectPinAboveMin();
	}
	//correctPinBelowMin
	public void CorrectPinBelowMin(){
		s.CorrectPinBelowMin();
	}
	//deposit
	public void Deposit(){
		s.Deposit();
	}
	//aboveMin
	public void AboveMinBalance(){
		s.AboveMinBalance();
	}
	//belowMin
	public void BelowMinBalance(){
		s.BelowMinBalance();
	}
	
	//logout
	public void Logout(){
		s.Logout();
	}
	
	//balance
	public void Balance(){
		s.Balance();
	}
	
	//withdraw
	public void Withdraw(){
		s.Withdraw();
	}
	
	// withdraw below min balance
	public void WithdrawBelowMinBalance(){
		s.WithdrawBelowMinBalance();
	}
	
	// nofunds
	public void NoFunds(){
		s.NoFunds();
	}
	
	//lock
	public void Lock(){
		s.Lock();
	}
	
	// incorrect lock
	public void IncorrectLock(){
		s.IncorrectLock();
	}
	
	//unlock
	public void Unlock(){
		s.Unlock();
	}
	
	// incorrect unlock
	public void IncorrectUnlock(){
		s.IncorrectUnlock();
	}
	
	//suspend
	public void Suspend(){
		s.suspend();
	}
	
	// activate
	public void Activate(){
		s.Activate();
	}
	
	//close
	public void Close(){
		s.close();
	}
}
