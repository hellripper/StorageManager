package abstractfactory;

import datastore.DS;
import datastore.DS1;
import strategy.displaybal.DisplayBal;
import strategy.displaybal.DisplayBal1;
import strategy.displaymenu.DisplayMenu;
import strategy.displaymenu.DisplayMenu1;
import strategy.incorrectlockmessage.IncorrectLockMessage;
import strategy.incorrectlockmessage.IncorrectLockMessage1;
import strategy.incorrectmsgid.IncorrectMsgId;
import strategy.incorrectmsgid.IncorrectMsgId1;
import strategy.incorrectpinmessage.IncorrectPinMessage;
import strategy.incorrectpinmessage.IncorrectPinMessage1;
import strategy.incorretunlockmessage.IncorrectUnlockMessage1;
import strategy.incorretunlockmessage.IncorrectunlockMessage;
import strategy.makedeposit.MakeDeposit;
import strategy.makedeposit.MakeDeposit1;
import strategy.makepenalty.MakePenalty;
import strategy.makepenalty.MakePenalty1;
import strategy.makewithdraw.MakeWithdraw;
import strategy.makewithdraw.MakeWithdraw1;
import strategy.nofundsmessage.NoFundsMessage;
import strategy.nofundsmessage.NoFundsMessage1;
import strategy.promptforpin.PromptForPin;
import strategy.promptforpin.PromptForPin1;
import strategy.storedata.StoreData;
import strategy.storedata.StoreData1;
import strategy.toomanyattemptsmessage.TooManyAttemptsMessage;
import strategy.toomanyattemptsmessage.TooManyAttemptsMessage1;

public class CF1 extends AF{

	@Override
	public DS getDS() {
		// TODO Auto-generated method stub
		return new DS1();
	}

	@Override
	public StoreData getStoreData() {
		// TODO Auto-generated method stub
		return new StoreData1();
	}

	@Override
	public IncorrectPinMessage getIncorrectPinMessage() {
		// TODO Auto-generated method stub
		return new IncorrectPinMessage1();
	}

	@Override
	public IncorrectMsgId getIncorrectMsgId() {
		// TODO Auto-generated method stub
		return new IncorrectMsgId1();
	}

	@Override
	public TooManyAttemptsMessage getTooManyAttemptsMessage() {
		// TODO Auto-generated method stub
		return new TooManyAttemptsMessage1();
	}

	@Override
	public DisplayMenu getDisplayMenu() {
		// TODO Auto-generated method stub
		return new DisplayMenu1();
	}

	@Override
	public MakeDeposit getMakeDeposit() {
		// TODO Auto-generated method stub
		return new MakeDeposit1();
	}

	@Override
	public DisplayBal getDisplayBal() {
		// TODO Auto-generated method stub
		return new DisplayBal1();
	}

	@Override
	public PromptForPin getPromptForPin() {
		// TODO Auto-generated method stub
		return new PromptForPin1();
	}

	@Override
	public MakeWithdraw getMakeWithdraw() {
		// TODO Auto-generated method stub
		return new MakeWithdraw1();
	}

	@Override
	public MakePenalty getMakePenalty() {
		// TODO Auto-generated method stub
		return new MakePenalty1();
	}

	@Override
	public IncorrectLockMessage getIncorrectLockMessage() {
		// TODO Auto-generated method stub
		return new IncorrectLockMessage1();
	}

	@Override
	public IncorrectunlockMessage getIncorrectUnlockMessage() {
		// TODO Auto-generated method stub
		return new IncorrectUnlockMessage1();
	}

	@Override
	public NoFundsMessage getNoFundsMessage() {
		// TODO Auto-generated method stub
		return new NoFundsMessage1();
	}

}
