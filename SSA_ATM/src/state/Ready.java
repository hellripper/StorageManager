package state;

import mdaefsm.MDAEFSM;

public class Ready extends State {

	public Ready(MDAEFSM mda) {
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

	}

	@Override
	public void CorrectPinBelowMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CorrectPinAboveMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Deposit() {
		// TODO Auto-generated method stub
		op.MakeDeposit();
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
		p.changeState(1);
	}

	@Override
	public void Balance() {
		// TODO Auto-generated method stub
		op.DisplayBalance();
	}

	@Override
	public void Withdraw() {
		// TODO Auto-generated method stub
		op.MakeWithdraw();
		p.changeState(4);
	}

	@Override
	public void WithdrawBelowMinBalance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void NoFunds() {
		// TODO Auto-generated method stub
		op.NoFundsMessage();
	}

	@Override
	public void Lock() {
		// TODO Auto-generated method stub
		p.changeState(6);
	}

	@Override
	public void IncorrectLock() {
		// TODO Auto-generated method stub
		op.IncorrectLockMessage();
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
		p.Suspend();
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
