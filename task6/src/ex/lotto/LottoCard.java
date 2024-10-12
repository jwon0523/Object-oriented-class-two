package ex.lotto;

public class LottoCard {
	private Lotto mLottos[];
	private int mNum;
	
	public LottoCard(int n) {
		this.mNum = n;
		if(n < 1) {
			System.out.println("1개 이상 구매해야 합니다.");
		}
		this.mLottos = new Lotto[this.mNum];
	}
	
	public boolean auto(int idx) {
		if(idx < 0 || idx > this.mNum - 1) {
			System.out.println("구매한 개수 안에서만 입력해 주세요.");
			return false;
		}
		this.mLottos[idx] = new Lotto();
		
		return this.mLottos[idx].getIsValid();
	}
	
	public boolean manual(int idx, int arr[]) {
		this.mLottos[idx] = new Lotto(arr);
		
		if(!this.mLottos[idx].getIsValid()) {
      return false;
		}
		
		return this.mLottos[idx].getIsValid();
	}
	
	public boolean manual(int idx, int n1, int n2, int n3, int n4, int n5, int n6) {
		this.mLottos[idx] = new Lotto(n1, n2, n3, n4, n5, n6);
		
		if(!this.mLottos[idx].getIsValid()) {
      return false;
		}
		
		return this.mLottos[idx].getIsValid();
	}
	
	public int[] get(int idx) {
		if (idx < 0 || idx >= mLottos.length || mLottos[idx] == null) {
      return null;
  }
		return this.mLottos[idx].getNumbers();
	}
	
	public void show() {
		for(int i = 0; i < this.mNum; i++) {
			if(!this.mLottos[i].getIsValid())
				System.out.println("복권" + (i + 1) + "에 잘못된 번호가 설정됨!");
			System.out.print("복권" + (i + 1) + ": ");
			this.mLottos[i].show();
		}
	}
}
