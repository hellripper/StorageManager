package state;

import mdaefsm.MDAEFSM;
import op.OP;

// This class is an abstract class. It is a part of State Pattern
// State "Start", "Idle", "CheckPin", "Ready", "S1", "Overdrawn", "Locked" are all inheriting from this class.
public abstract class State {
	protected MDAEFSM p;
	protected OP op;
	
	public State(MDAEFSM mda){
		p=mda;
		op=new OP();
	}
	
	public abstract void Open();
	public abstract void Login();
	public abstract void IncorrectLogin();
	public abstract void IncorectPin(int Max);
	public abstract void CorrectPinBelowMin();
	public abstract void CorrectPinAboveMin();
	public abstract void Deposit();
	public abstract void BelowMinBalance();
	public abstract void AboveMinBalance();
	public abstract void Logout();
	public abstract void Balance();
	public abstract void Withdraw();
	public abstract void WithdrawBelowMinBalance();
	public abstract void NoFunds();
	public abstract void Lock();
	public abstract void IncorrectLock();
	public abstract void Unlock();
	public abstract void IncorrectUnlock();
	public abstract void suspend();
	public abstract void Activate();
	public abstract void close();
	
}
