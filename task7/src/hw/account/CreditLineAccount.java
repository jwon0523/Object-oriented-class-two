package hw.account;

public class CreditLineAccount extends Account {
	int creditLine;
	
	public CreditLineAccount(
			String accountNo, 
			String name, 
			int balance,
			int creditLine
	) {
		super(accountNo, name, balance);
		this.creditLine = creditLine;
	}
	
	@Override
	protected int withdraw(int amount) {
		int minusAccountBalance = this.balance + this.creditLine;
		if(minusAccountBalance < amount) {
			System.out.println("마이너스 한도를 초과했습니다.");
			return 0;
		}
		this.balance -= amount;
		
		return amount;
	}
}
