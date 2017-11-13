package abstractfactory;

import datastore.DS;
import datastore.DS2;
import strategy.displaybal.DisplayBal;
import strategy.displaybal.DisplayBal2;
import strategy.displaymenu.DisplayMenu;
import strategy.displaymenu.DisplayMenu2;
import strategy.incorrectlockmessage.IncorrectLockMessage;
import strategy.incorrectlockmessage.IncorrectlockMessage2;
import strategy.incorrectmsgid.IncorrectMsgId;
import strategy.incorrectmsgid.IncorrectMsgId2;
import strategy.incorrectpinmessage.IncorrectPinMessage;
import strategy.incorrectpinmessage.IncorrectPinMessage2;
import strategy.incorretunlockmessage.IncorrectUnlockMessage2;
import strategy.incorretunlockmessage.IncorrectunlockMessage;
import strategy.makedeposit.MakeDeposit;
import strategy.makedeposit.MakeDeposit2;
import strategy.makepenalty.MakePenalty;
import strategy.makepenalty.MakePenalty2;
import strategy.makewithdraw.MakeWithdraw;
import strategy.makewithdraw.MakeWithdraw2;
import strategy.nofundsmessage.NoFundsMessage;
import strategy.nofundsmessage.NoFundsMessage2;
import strategy.promptforpin.PromptForPin;
import strategy.promptforpin.PromptForPin2;
import strategy.storedata.StoreData;
import strategy.storedata.StoreData2;
import strategy.toomanyattemptsmessage.TooManyAttemptsMessage;
import strategy.toomanyattemptsmessage.TooManyAttemptsMessage2;

public class CF2 extends AF{
	@Override
	public DS getDS() {
		// TODO Auto-generated method stub
		return new DS2();
	}

	@Override
	public StoreData getStoreData() {
		// TODO Auto-generated method stub
		return new StoreData2();
	}

	@Override
	public IncorrectPinMessage getIncorrectPinMessage() {
		// TODO Auto-generated method stub
		return new IncorrectPinMessage2();
	}

	@Override
	public IncorrectMsgId getIncorrectMsgId() {
		// TODO Auto-generated method stub
		return new IncorrectMsgId2();
	}

	@Override
	public TooManyAttemptsMessage getTooManyAttemptsMessage() {
		// TODO Auto-generated method stub
		return new TooManyAttemptsMessage2();
	}

	@Override
	public DisplayMenu getDisplayMenu() {
		// TODO Auto-generated method stub
		return new DisplayMenu2();
	}

	@Override
	public MakeDeposit getMakeDeposit() {
		// TODO Auto-generated method stub
		return new MakeDeposit2();
	}

	@Override
	public DisplayBal getDisplayBal() {
		// TODO Auto-generated method stub
		return new DisplayBal2();
	}

	@Override
	public PromptForPin getPromptForPin() {
		// TODO Auto-generated method stub
		return new PromptForPin2();
	}

	@Override
	public MakeWithdraw getMakeWithdraw() {
		// TODO Auto-generated method stub
		return new MakeWithdraw2();
	}

	@Override
	public MakePenalty getMakePenalty() {
		// TODO Auto-generated method stub
		return new MakePenalty2();
	}

	@Override
	public IncorrectLockMessage getIncorrectLockMessage() {
		// TODO Auto-generated method stub
		return new IncorrectlockMessage2();
	}

	@Override
	public IncorrectunlockMessage getIncorrectUnlockMessage() {
		// TODO Auto-generated method stub
		return new IncorrectUnlockMessage2();
	}

	@Override
	public NoFundsMessage getNoFundsMessage() {
		// TODO Auto-generated method stub
		return new NoFundsMessage2();
	}
}
