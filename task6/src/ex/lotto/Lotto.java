package ex.lotto;

import java.util.Random;

public class Lotto {
	private int mLottoNumber[];
	private boolean mIsValid;
	
	Lotto(int n1, int n2, int n3, int n4, int n5, int n6) {
		
		this.mLottoNumber = new int[6];
		
		this.mLottoNumber[0] = n1;
		this.mLottoNumber[1] = n2;
		this.mLottoNumber[2] = n3;
		this.mLottoNumber[3] = n4;
		this.mLottoNumber[4] = n5;
		this.mLottoNumber[5] = n6;
		
		this.mIsValid = verify();
	}
	
	Lotto(int lotto[]) {
		this.mLottoNumber = new int[6];
		this.mLottoNumber = lotto;
		
		this.mIsValid = verify();
	}
	
	Lotto() {
		this.mLottoNumber = generate();
	}
	
	boolean getIsValid() {
		return this.mIsValid;
	}
	
	boolean verify() {
		int len = mLottoNumber.length;
		
		if(len < 1 || len > 6)
			return false;
		
		for(int i = 0; i < len; i++)
			if(this.mLottoNumber[i] < 0 || this.mLottoNumber[i] > 45)
				return false;
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++)
				if(i != j) {
					if(mLottoNumber[i] == mLottoNumber[j])
						return false;
				}
		}
		return true;
	}
	
	int[] generate() {
    Random random = new Random();
    int numArray[] = new int[6];
    int idx = 0;
    
    while (idx < 6) {
        int n = random.nextInt(45) + 1;
        boolean isDuplicate = false;

        for (int j = 0; j < idx; j++) {
            if (n == numArray[j]) {
                isDuplicate = true;
                break;
            }
        }

        if (!isDuplicate) {
            numArray[idx] = n;
            idx++;
        }
    }
    this.mIsValid = true;

    return numArray;
}
	
	void show() {
		if(this.mIsValid) {
			for(int i = 0; i < this.mLottoNumber.length; i++) {
				System.out.print(this.mLottoNumber[i] + " ");
			}
			System.out.println();
		} else {
			System.out.print("로또 번호 오류: ");
			for(int i = 0; i < this.mLottoNumber.length; i++) {
				System.out.print(this.mLottoNumber[i] + " ");
			}
			System.out.println();
		}
	}
	
	int[] getNumbers() {
		if(this.mIsValid) {
			return this.mLottoNumber;
		}	else {
			return null;
		}
	}
}
