package Q2;

public class CurrentAccount extends Account{
private float minimumBalance;

public CurrentAccount(){
	this.minimumBalance=2000;
}

public CurrentAccount(CurrentAccount account){
	super(account.getOwner(),account.getBalance(),account.getNumber());
	this.minimumBalance=account.minimumBalance;
}

public void input() {
	super.input();
	
}

public void print() {
	super.print();
	System.out.println("Minimum Balance: "+this.minimumBalance);
}



}
