package exception;

public class WithdrawalException extends Exception {
	private final static String errorCode="Withdrawal Exception";
	
	public String getErrorCode(){
		return errorCode;
	}
}
