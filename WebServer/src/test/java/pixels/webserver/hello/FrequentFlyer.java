package pixels.webserver.hello;

public class FrequentFlyer {

	private int balance;
	
	
	
	public static FrequentFlyer withInitialBalanceOf(int initialBalance) {
		FrequentFlyer ff = new FrequentFlyer();
		ff.balance=initialBalance;
		return ff;
	}

	public int getBalance() {
		return balance;
	}

	public String getStatus() {
		if(balance >=10000)
			return "Silver";
		return "Bronce";
	}

	public void flies(int distance) {
		balance += distance;
		
	}

}
