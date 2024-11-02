package hw.account;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account ac[] = new Account[5];
		ac[0] = new Account("1", "JaeWon", 10000);
		ac[1] = new CheckingAccount("2", "hansung", 5000, "card1");
		ac[2] = new CheckingTrafficCardAccount("3", "com", 5000, "card2", true);
		ac[3] = new CreditLineAccount("4", "mobile", 1000, 5000);
		ac[4] = new BonusPointAccount("5", "bonus", 20000);
		
		for(Account bank : ac) {
			System.out.println("------------------");
			bank.check();
			bank.deposit(5000);
			if(bank instanceof CheckingAccount) {
				CheckingAccount ca = (CheckingAccount) bank;
				System.out.println("교통카드에서 " + ca.pay(ca.getCardNo(), 4000) + "원 출금됐습니다.");
			} else if(bank instanceof CheckingTrafficCardAccount) {
				CheckingTrafficCardAccount trafficAc = (CheckingTrafficCardAccount) bank;
				trafficAc.payTrafficCard(trafficAc.getCardNo(), 3000);
			} else if(bank instanceof CreditLineAccount) {
				System.out.println(((CreditLineAccount) bank).withdraw(10000) + "원 출금했습니다.");
				System.out.println(((CreditLineAccount) bank).withdraw(8000) + "원 출금했습니다.");
			} else if(bank instanceof BonusPointAccount) {
				System.out.println(((BonusPointAccount) bank).withdraw(10000) + "원 출금했습니다.");
			}
			bank.check();
			System.out.println();
		}
	}

}
