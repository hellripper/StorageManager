package state;

import mdaefsm.MDAEFSM;

public class CheckPin extends State {

	public CheckPin(MDAEFSM mda) {
		super(mda);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Open() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void IncorrectLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IncorectPin(int Max) {
		// TODO Auto-generated method stub
		int tempAtt=p.getAttempts();
		if(tempAtt < Max){
			p.setAttempts(tempAtt+1);
			op.IncorrectPinMessage();
		}else{
			op.IncorrectPinMessage();
			op.TooManyAttemptsMessage();
			p.changeState(1);
		}
	}

	@Override
	public void CorrectPinBelowMin() {
		// TODO Auto-generated method stub
		op.DisplayMenu();
		p.changeState(5);
	}

	@Override
	public void CorrectPinAboveMin() {
		// TODO Auto-generated method stub
		op.DisplayMenu();
		p.changeState(3);
	}

	@Override
	public void Deposit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void BelowMinBalance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void AboveMinBalance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Balance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Withdraw() {
		// TODO Auto-generated method stub

	}

	@Override
	public void WithdrawBelowMinBalance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void NoFunds() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Lock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void IncorrectLock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Unlock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void IncorrectUnlock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void suspend() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

}
