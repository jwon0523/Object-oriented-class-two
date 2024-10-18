package hw.account;

public class Account {
	String accountNo;
	String name;
	int balance;
	
	public Account(String accountNo, String name, int balance) {
		if(balance < 0) {
			System.out.println("0보다 큰 수를 입력해 주세요.");
			return;
		}
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	
	protected void deposit(int amount) {
		if(amount < 0) {
			System.out.println("0보다 큰 수를 입력해 주세요.");
			return;
		}
		System.out.println(amount + "원 입금했습니다.");
		this.balance += amount;
	}
	
	protected int withdraw(int amount) {
		if(amount > this.balance || amount < 0) {
			System.out.println("잔액 안에서만 출금 가능합니다.");
			return 0;
		}
		this.balance -= amount;
		
		return amount;
	}
		
	protected void check() {
		System.out.println("계좌번호: " + this.accountNo);
		System.out.println("예금주: " + this.name);
		System.out.println("잔액이 " +  this.balance + "원 남았습니다.");
	}
}
