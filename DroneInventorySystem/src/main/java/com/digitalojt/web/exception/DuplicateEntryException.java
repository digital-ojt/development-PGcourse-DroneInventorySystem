package com.digitalojt.web.exception;

import java.util.ResourceBundle;

/**
 * 登録重複例外
 * 
 * @author dotlife
 *
 */
public class DuplicateEntryException extends RuntimeException {
	private static final ResourceBundle messages = ResourceBundle.getBundle("messages");
    public DuplicateEntryException(String message) {
    	super(messages.getString(message));
    }
}
