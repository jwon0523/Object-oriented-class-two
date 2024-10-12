package ex.hw;

import ex.lotto.LottoCard;

public class LottoSimApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(">> 1차 구매");
		LottoCard card1 = new LottoCard(2);
		card1.manual(0, 1, 11, 22, 33, 44, 45);
    card1.manual(1, 3, 9, 15, 17, 33, 45);
    card1.show();
    
    System.out.println("\n>> 2차 구매");
    LottoCard card2 = new LottoCard(5);
    card2.auto(0);
    card2.auto(1);
    card2.auto(2);
    card2.auto(3);
    card2.auto(4);
    card2.show();
    
   System.out.println("-------------------------");
    
    System.out.println("\n>> 1차 구매");
    int num[] = {1, 11, 22, 33, 44, 47};
    card1.manual(0, num);
    card1.manual(1, 3, 9, 15, 17, 33, 45);
    card1.show();

    System.out.println("\n>> 2차 구매");
    card2.auto(0);
    card2.auto(1);
    card2.auto(2);
    card2.auto(3);
    card2.auto(4);
    card2.show();
	}

}
