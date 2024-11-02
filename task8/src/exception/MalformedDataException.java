package exception;

public class MalformedDataException extends Exception {
	
	public MalformedDataException() {
		this("오류: 잘못된 금액입니다.");
	}
	
	public MalformedDataException(String errMsg) {
		super(errMsg);
	}
	
}
