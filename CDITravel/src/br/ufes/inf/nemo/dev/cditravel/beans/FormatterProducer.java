package br.ufes.inf.nemo.dev.cditravel.beans;

import br.ufes.inf.nemo.dev.cditravel.qualifiers.CurrencyFormatter;
import br.ufes.inf.nemo.dev.cditravel.qualifiers.IntegerFormatter;

import java.text.*;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class FormatterProducer {
	private static final Locale LOCALE = new Locale("en", "US");

	@Produces
	private static final DateFormat DF = new SimpleDateFormat("MM/dd/yyyy");

	@Produces @CurrencyFormatter
	private final NumberFormat CF = NumberFormat.getCurrencyInstance(LOCALE);

	@Produces @IntegerFormatter
	private final NumberFormat IF = NumberFormat.getIntegerInstance(LOCALE);

	public FormatterProducer() {
		IF.setMinimumIntegerDigits(2);
	}
}
