package org.ecom.cart.exception;


public class DiscountProcessException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	/**
	 * Creates an instance of DiscountProcessException with specified errorCode and message.
	 * 
	 * @param errorCode
	 * @param message
	 */
	public DiscountProcessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Creates an instance of DiscountProcessException with specified errorCode and
	 * Exception reference.
	 * 
	 * @param errorCode
	 * @param e
	 */
	public DiscountProcessException(String errorCode, Exception e) {
		super(e);
		this.errorCode = errorCode;
	}

	// Getter and setter methods of errorCode.
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public DiscountProcessException() {
		super();
	}

	public DiscountProcessException(String message) {
		super(message);
	}

	public DiscountProcessException(Throwable t) {
		super(t);
	}

	public DiscountProcessException(String message, Throwable t) {
		super(message, t);
	}

	public DiscountProcessException(String errorCode, String message, Exception e) {
		super(message, e);
		this.errorCode = errorCode;
	}
}
