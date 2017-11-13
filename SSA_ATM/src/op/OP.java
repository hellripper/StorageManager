package op;

import driver.TestDriver;
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

//This class is the output processor of the MDA-EFSM architecture.
//This output processor performs actions by the abstract factory pattern and strategy pattern.
public class OP {
	private DisplayBal db;
	private DisplayMenu dm;
	private IncorrectLockMessage ilm;
	private IncorrectMsgId imi;
	private IncorrectPinMessage ipm;
	private IncorrectunlockMessage ium;
	private MakeDeposit md;
	private MakePenalty mp;
	private MakeWithdraw mw;
	private NoFundsMessage nfm;
	private PromptForPin pfp;
	private StoreData sd;
	private TooManyAttemptsMessage tmam;
	
	//These are the actions that the output processor can perform.
	public void DisplayBalance(){
		db = TestDriver.factory.getDisplayBal();
		db.displayBal();
	}
	
	public void DisplayMenu(){
		dm = TestDriver.factory.getDisplayMenu();
		dm.displayMenu();
	}
	
	public void IncorrectLockMessage(){
		ilm = TestDriver.factory.getIncorrectLockMessage();
		ilm.incorrectLockMessage();
	}
	
	public void IncorrectMsgId(){
		imi = TestDriver.factory.getIncorrectMsgId();
		imi.incorrectMsgId();
	}
	
	public void IncorrectPinMessage(){
		ipm = TestDriver.factory.getIncorrectPinMessage();
		ipm.incorrectPinMessage();
	}
	
	public void incorrectunlockMessage(){
		ium = TestDriver.factory.getIncorrectUnlockMessage();
		ium.incorrectUnlockMessage();
	}
	
	public void MakeDeposit(){
		md = TestDriver.factory.getMakeDeposit();
		md.makeDeposit();
	}
	
	public void MakePenalty(){
		mp = TestDriver.factory.getMakePenalty();
		mp.makePenalty();
	}
	
	public void MakeWithdraw(){
		mw = TestDriver.factory.getMakeWithdraw();
		mw.makeWithdraw();
	}
	
	public void NoFundsMessage(){
		nfm = TestDriver.factory.getNoFundsMessage();
		nfm.noFundsMessage();
	}
	
	public void PromptForPin(){
		pfp = TestDriver.factory.getPromptForPin();
		pfp.promptForPin();
	}
	
	public void StoreData(){
		sd = TestDriver.factory.getStoreData();
		sd.storeData();
	}
	
	public void TooManyAttemptsMessage(){
		tmam = TestDriver.factory.getTooManyAttemptsMessage();
		tmam.tooManyAttemptsMessage();
	}
}
