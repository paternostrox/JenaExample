package br.ufes.inf.nemo.dev.cditravel.beans;

import java.io.Serializable;
import java.util.*;
import javax.enterprise.context.*;
import javax.inject.Named;

@SessionScoped
@Named
public class ListConversations implements Serializable {
	private List<String> conversationIds = new ArrayList<String>();

	public void add(Conversation conversation) {
		conversationIds.add(conversation.getId());
	}

	public void remove(Conversation conversation) {
		conversationIds.remove(conversation.getId());
	}

	public List<String> getList() {
		return conversationIds;
	}
}