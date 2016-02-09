package by.epam.kovalchuk.exception;

public class ExchangerException extends Exception {

	private static final long serialVersionUID = -1341282873066882476L;

	public ExchangerException() {
	}

	public ExchangerException(String message) {
		super(message);
	}

	public ExchangerException(String message, Throwable cause) {
		super(message, cause);
	}

}
