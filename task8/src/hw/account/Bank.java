package hw.account;

import exception.MalformedDataException;
import exception.BalanceOutOfBoundsException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String errMsg;
		
		Vector<Account> accountList = new Vector<Account>(2);
		accountList.add(new Account("1", "Jaewon", 10000));
		accountList.add(new Account("2", "hansung", 5000));
		accountList.add(new Account("3", "bugi", 50000));
		accountList.add(new Account("4", "com", 1000));
		
		Iterator<Account> itr1 = accountList.iterator();
		while(itr1.hasNext()) {
			try {
				Account currentAc = itr1.next();
				currentAc.check();
				currentAc.deposit(5000);
				currentAc.withdraw(100000);
			} catch(MalformedDataException e) {
				errMsg = e.getMessage();
				System.out.println(errMsg);
			} catch(BalanceOutOfBoundsException e) {
				errMsg = e.getMessage();
				System.out.println(errMsg);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("-------- HashSet ---------");
		System.out.println();
		
		HashSet<Account> accountSet = new HashSet<Account>();
		accountSet.add(new Account("1", "Jaewon", 10000));
		accountSet.add(new Account("2", "hansung", 5000));
		accountSet.add(new Account("3", "bugi", 50000));
		accountSet.add(new Account("3", "com", 1000));
		
		Iterator<Account> itr2 = accountSet.iterator();
		while(itr2.hasNext()) {
			try {
				Account currentAc = itr2.next();
				currentAc.check();
				currentAc.deposit(-5000);
				currentAc.withdraw(100000);
			} catch(MalformedDataException e) {
				errMsg = e.getMessage();
				System.out.println(errMsg);
			} catch(BalanceOutOfBoundsException e) {
				errMsg = e.getMessage();
				System.out.println(errMsg);
			}
			System.out.println();
		}
		
	}

}
