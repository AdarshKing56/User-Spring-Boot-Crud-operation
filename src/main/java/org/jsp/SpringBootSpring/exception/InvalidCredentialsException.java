package org.jsp.SpringBootSpring.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {

		return "Invalid id or password and enail";
	}
}
