package hw.account;

public class CheckingTrafficCardAccount extends CheckingAccount {
	boolean hasTrafficCard;
	
	public CheckingTrafficCardAccount(
			String accountNo, 
			String name, 
			int balance, 
			String cardNo,
			boolean hasTrafficCard
	) {
		super(accountNo, name, balance, cardNo);
		this.hasTrafficCard = hasTrafficCard;
	}
	
	int payTrafficCard(String cardNo, int amount) {
		if(this.hasTrafficCard) {
		// 오버라이딩 통해 부모의 pay 함수가 은폐된 경우만 super 사용.
			return this.pay(cardNo, amount); 
		} else {
			System.out.println("교통카드 등록이 안 된 카드입니다.");
			return -1;
		}
	}
}
