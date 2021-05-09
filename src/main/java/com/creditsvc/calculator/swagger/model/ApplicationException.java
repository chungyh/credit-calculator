package com.creditsvc.calculator.swagger.model;

import com.creditsvc.calculator.swagger.model.Error;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -287212933611305370L;

	private String errorCode;
	
	private transient Object[] errorContext;
	
	private transient Error innerError;
	
	private transient String httpstatus;
	
	private String errDesc;
	
	public ApplicationException() {
		super();
	}
	
	public ApplicationException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public ApplicationException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public ApplicationException(String errorCode, Throwable cause) {
		super(errorCode, cause);
		this.errorCode = errorCode;
	}

	public ApplicationException(String errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public ApplicationException errDesc(String errorDesc){
		this.errDesc = errorDesc;
		return this;
	}
	
	public ApplicationException addContext(Object...context) {
		errorContext = new Object[context.length];
		int i = 0;
		for (Object item : context) {
			errorContext[i++] = item;
		}
		return this;
	}
	
	public Object[] getErrorContext() {
		return errorContext;
	}
	
	
	public Error getInnerError() {
		return innerError;
	}

	public ApplicationException addInnerError(Error innerError) {
		this.innerError = innerError;
		return this;
	}
	
	public String getErrDesc(){
		return this.errDesc;
	}
	
	public ApplicationException addHttpStatusCode(String httpStatus) {
		this.httpstatus = httpStatus;
		return this;
	}

	public String getHttpstatus() {
		return httpstatus;
	}

}
