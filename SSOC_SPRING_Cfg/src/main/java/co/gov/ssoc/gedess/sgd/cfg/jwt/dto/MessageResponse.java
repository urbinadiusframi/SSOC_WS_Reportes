package co.gov.ssoc.gedess.sgd.cfg.jwt.dto;

import java.io.Serializable;

public class MessageResponse implements Serializable {

	private static final long serialVersionUID = 1871L;

	private String message;

	public MessageResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
