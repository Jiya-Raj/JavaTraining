package com.app.util;

import org.springframework.stereotype.Component;

@Component
public class MessageFormatter {

	public String format(String message) {
		return message.toUpperCase();
	}

}
