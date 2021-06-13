import java.util.Random;


public class BankAccount {
	String accountNumber = "";
	private double checkingBalance;
	private double savingsBalance;
	static int numberOfAccounts = 0;
	static double totalMoney = 0;

	private void tenRandom() {
		Random rand = new Random();
		accountNumber = "";
		for (int i = 0; i < 10; i++) {
			accountNumber += rand.nextInt(10);
		}
	}

	public BankAccount() {
		this.tenRandom();
		numberOfAccounts += 1;

	}

	public double getCheckingBalance() {
		return this.checkingBalance;
	}

	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public void deposit(char type, double money) {
		if (type == 'c') {
			this.checkingBalance += money;
			totalMoney += money;
		}
		else if (type == 's') {
			this.savingsBalance += money;
			totalMoney += money;
		}
		else {
			System.out.println("no such balacne type");
		}
	}

	public void withdraw(double money) {
		if (money < this.getCheckingBalance()) {
			this.checkingBalance -= money;
			totalMoney -= money;
		}
		else {
			System.out.println("insufficient funds");
		}
	}

	public double showTotal() {
		return totalMoney;
	}
}
