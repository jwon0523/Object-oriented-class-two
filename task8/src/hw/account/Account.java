package hw.account;

import exception.MalformedDataException;
import exception.BalanceOutOfBoundsException;
import java.util.HashSet;
import java.util.Iterator;

public class Account {
	private String accountNo;
	private String name;
	private int balance;
	
	public Account(String accountNo, String name, int balance) {
		if(balance < 0) {
			System.out.println("0보다 큰 수를 입력해 주세요.");
			return;
		}
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	
	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Account) {
			Account ac = (Account)obj;
			if(ac.accountNo == this.accountNo) 
				return true;
		}
		return false;
	}
	
	
	protected void deposit(int amount) throws MalformedDataException {
		if(amount < 0) {
			throw new MalformedDataException("오류: 잘못된 금액입니다.");
		}
		System.out.println(amount + "원 입금했습니다.");
		this.balance += amount;
	}
	
	protected int withdraw(int amount) throws MalformedDataException, BalanceOutOfBoundsException {
		if(amount < 0) {
			throw new MalformedDataException("오류: 잘못된 금액입니다.");
		}
		if(amount > this.balance) {
			throw new BalanceOutOfBoundsException("인출오류: 잔액을 초과하였습니다.");
		}
		this.balance -= amount;
		
		return amount;
	}
		
	protected void check() {
		System.out.println("계좌번호: " + this.accountNo);
    System.out.println("예금주: " + this.name);
    System.out.println("잔액이 " + this.balance + "원 남았습니다.");
}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int amount) {
		this.balance += amount;
	}

}
