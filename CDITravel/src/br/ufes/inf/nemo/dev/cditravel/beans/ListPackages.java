package br.ufes.inf.nemo.dev.cditravel.beans;

import br.ufes.inf.nemo.dev.cditravel.domain.TourPackage;
import br.ufes.inf.nemo.dev.cditravel.interceptors.Timed;
import br.ufes.inf.nemo.dev.cditravel.qualifiers.CurrencyFormatter;
import br.ufes.inf.nemo.dev.cditravel.qualifiers.IntegerFormatter;

import java.text.NumberFormat;
import java.util.List;
import java.util.logging.*;

import javax.ejb.Stateless;
import javax.inject.*;

@Stateless
@Named("lp")
public class ListPackages {
	private static final Logger logger = Logger.getLogger(ListPackages.class.getCanonicalName());

	private NumberFormat nf;
	private NumberFormat nfi;

	@Inject
	private List<TourPackage> packages;

	public ListPackages() {}

	@Inject
	public ListPackages(@CurrencyFormatter NumberFormat nf, @IntegerFormatter NumberFormat nfi) {
		this.nf = nf;
		this.nfi = nfi;
	}

	public List<TourPackage> getPackages() {
		return packages;
	}

	@Timed
	public String getAveragePrice() {
		double total = 0;
		for (TourPackage pack : packages) {
			total += pack.getPrice().doubleValue();
		}
		int count = packages.size();
		double average = (count == 0) ? 0 : total / count;
		String s = nf.format(average);
		logger.log(Level.INFO, "Calculated average price over {0} tour packages: {1}", new Object[] {count, s});
		return s;
	}

	public String getPackageCount() {
		return nfi.format(packages.size());
	}
}
