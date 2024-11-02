package exception;

public class BalanceOutOfBoundsException extends RuntimeException {	
	public BalanceOutOfBoundsException() {
		this("인출오류: 잔액을 초과하였습니다.");
	}
	
	public BalanceOutOfBoundsException(String errMsg) {
		super(errMsg);
	}
}
