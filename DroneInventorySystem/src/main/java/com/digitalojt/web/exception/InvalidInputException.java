package com.digitalojt.web.exception;

import java.util.ResourceBundle;

/**
 * 入力値不正例外
 * 
 * @author dotlife
 *
 */

public class InvalidInputException extends RuntimeException {
	private static final ResourceBundle messages = ResourceBundle.getBundle("messages");

	public InvalidInputException(String messageKey) {
		super(messages.getString(messageKey));
	}
}
