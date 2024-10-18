package hw.account;

public class BonusPointAccount extends Account {
	int bonusPoint;
	
	public BonusPointAccount(
			String accountNo, 
			String name, 
			int balance
	) {
		super(accountNo, name, balance);
		this.bonusPoint = 0;
	}
	
	@Override
	protected void deposit(int amount) {
		super.deposit(amount);
		this.bonusPoint += amount * 0.1;
	}
	
	@Override
	protected void check() {
		super.check();
		System.out.println("보너스 포인트: " + this.bonusPoint);
	}
}
