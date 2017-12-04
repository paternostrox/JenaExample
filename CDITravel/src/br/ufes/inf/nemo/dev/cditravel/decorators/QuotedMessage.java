package br.ufes.inf.nemo.dev.cditravel.decorators;

import br.ufes.inf.nemo.dev.cditravel.beans.Message;

import javax.decorator.*;
import javax.inject.Inject;

@Decorator
public class QuotedMessage implements Message {
	@Inject
	@Delegate
	private Message message;

	@Override
	public String getMessage() {
		return "\"" + message.getMessage() + "\"";
	}
}