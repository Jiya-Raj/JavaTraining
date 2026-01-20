package q2_AccountSynchronization;

public class MainAccountTest {

	public static void main(String[] args) {

		Account account = new Account(10000);

		Thread bankThread = new Thread(new Bank(account), "BankThread");
		Thread companyThread = new Thread(new Company(account), "CompanyThread");

		bankThread.start();
		companyThread.start();

		try {
			bankThread.join();
			companyThread.join();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}

		System.out.println("Final Balance: " + account.getBalance());
	}
}
