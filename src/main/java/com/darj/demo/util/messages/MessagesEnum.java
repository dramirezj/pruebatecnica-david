package com.darj.demo.util.messages;

import lombok.Getter;

@Getter
public enum MessagesEnum {

	UNKNOWN_ERROR(500, "generic.rest.error", MessageLevel.ERROR),
	JWT_USER_NOT_VALID(401, "jwt.user.not.valid", MessageLevel.ERROR),
	JWT_INVALID_TOKEN(401, "jwt.token.not.valid", MessageLevel.ERROR),
	UNAUTHORIZED_USER(403, "access.denied", MessageLevel.ERROR),
	
	RECORD_NOT_FOUND(400, "Ticket con id  no encontrado.", MessageLevel.ERROR),
	SUCCESSFULLY_OPERATION(400, "Operaci\u00F3n satisfactoria", MessageLevel.ERROR);
	
	private int code;
	private String message;

	private MessageLevel level;

	private MessagesEnum(int code, String message, MessageLevel level) {
		this.code = code;
		this.message = message;
		this.level = level;
	}

}
