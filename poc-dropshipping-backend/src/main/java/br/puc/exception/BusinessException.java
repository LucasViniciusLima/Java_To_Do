package br.puc.exception;

public class BusinessException extends Throwable {

	private static final long serialVersionUID = -3123807337753557166L;

	public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}