package com.ks.masapi.exception;

/**
 *  Application exception class
 */
public class AppException extends Exception
{

	private static final long serialVersionUID = 1L;

	public AppException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public AppException(String message)
	{
		super(message);
	}

	public AppException(Throwable cause)
	{
		super(cause);
	}
	
}
