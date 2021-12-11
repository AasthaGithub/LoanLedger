package com.example.geektrust.exceptions;

/**
 * DESCRIPTION - This class is wrapper over Exception. This is used wherever
 * Business condition violation occurs.
 * 
 * @author - Aastha
 * @version 1.0
 * @since <11-December-2021>
 */

public class BankingException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_ERROR_CODE = "";
	private final String mErrorCode;

	/**
	 * Throws valid Banking exception
	 */
	public BankingException() {
		super();
		this.mErrorCode = DEFAULT_ERROR_CODE;
	}

	/**
	 * Instantiates a new Banking exception.
	 * 
	 * @param errorMsg the error msg
	 */
	public BankingException(final String errorMsg) {
		super(errorMsg);
		this.mErrorCode = DEFAULT_ERROR_CODE;
	}

	/**
	 * Instantiates a new Banking exception.
	 * 
	 * @param errorCode the error code
	 * @param errorMsg  the error msg
	 */
	public BankingException(final String errorCode, final String errorMsg) {
		super(errorMsg);
		this.mErrorCode = errorCode;
	}

	/**
	 * @param cause
	 */
	public BankingException(Throwable cause) {
		super(cause);
		this.mErrorCode = DEFAULT_ERROR_CODE;
	}

	/**
	 * Instantiates a new Banking exception.
	 * 
	 * @param errorMsg the error msg
	 * @param cause    the cause
	 */
	public BankingException(final String errorMsg, final Throwable cause) {
		super(errorMsg, cause);
		this.mErrorCode = DEFAULT_ERROR_CODE;
	}

	/**
	 * Instantiates a new Banking exception.
	 * 
	 * @param errorCode the error code
	 * @param errorMsg  the error msg
	 * @param cause     the cause
	 */
	public BankingException(final String errorCode, final String errorMsg, final Throwable cause) {
		super(errorMsg, cause);
		this.mErrorCode = errorCode;
	}

	public String getErrorCode() {
		return mErrorCode;
	}
}
