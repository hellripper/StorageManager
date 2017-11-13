package abstractfactory;

import strategy.displaybal.DisplayBal;
import strategy.displaymenu.DisplayMenu;
import strategy.incorrectlockmessage.IncorrectLockMessage;
import strategy.incorrectmsgid.IncorrectMsgId;
import strategy.incorrectpinmessage.IncorrectPinMessage;
import strategy.incorretunlockmessage.IncorrectunlockMessage;
import strategy.makedeposit.MakeDeposit;
import strategy.makepenalty.MakePenalty;
import strategy.makewithdraw.MakeWithdraw;
import strategy.nofundsmessage.NoFundsMessage;
import strategy.promptforpin.PromptForPin;
import strategy.storedata.StoreData;
import strategy.toomanyattemptsmessage.TooManyAttemptsMessage;
import datastore.DS;

//This class AF is a part of Abstract Factory Pattern.
//It's an abstract class.
public abstract class AF {
	
	public abstract DS getDS();
	
	public abstract StoreData getStoreData();
	public abstract IncorrectPinMessage getIncorrectPinMessage();
	public abstract IncorrectMsgId getIncorrectMsgId();
	public abstract TooManyAttemptsMessage getTooManyAttemptsMessage();
	public abstract DisplayMenu getDisplayMenu();
	public abstract MakeDeposit getMakeDeposit();
	public abstract DisplayBal getDisplayBal();
	public abstract PromptForPin getPromptForPin();
	public abstract MakeWithdraw getMakeWithdraw();
	public abstract MakePenalty getMakePenalty();
	public abstract IncorrectLockMessage getIncorrectLockMessage();
	public abstract IncorrectunlockMessage getIncorrectUnlockMessage();
	public abstract NoFundsMessage getNoFundsMessage();
}
