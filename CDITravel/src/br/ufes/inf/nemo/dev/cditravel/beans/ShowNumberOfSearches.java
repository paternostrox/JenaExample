package br.ufes.inf.nemo.dev.cditravel.beans;

import br.ufes.inf.nemo.dev.cditravel.events.SearchEvent;

import java.io.Serializable;
import java.util.logging.*;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

@SessionScoped
@Named
public class ShowNumberOfSearches implements Serializable {
	private static final Logger logger = Logger.getLogger(ShowNumberOfSearches.class.getCanonicalName());

	private int qty = 0;

	public int getQty() {
		return qty;
	}

	public void countSearch(@Observes SearchEvent event) {
		logger.log(Level.INFO, "Counting one more search. Visitor searched by name: {0}", event.getName());
		qty++;
	}
}
