package br.ufes.inf.nemo.dev.cditravel.beans;

import br.ufes.inf.nemo.dev.cditravel.domain.TourPackage;
import br.ufes.inf.nemo.dev.cditravel.persistence.TourPackageDAO;

import java.util.List;
import java.util.logging.*;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.*;

@ApplicationScoped
public class PackageProducer {
	private static final Logger logger = Logger.getLogger(PackageProducer.class.getCanonicalName());

	@EJB
	private TourPackageDAO tourPackageDAO;

	@Produces
	public List<TourPackage> getAllPackages() {
		List<TourPackage> packages = tourPackageDAO.retrieveAll();
		logger.log(Level.INFO, "Producer loading tour packages: {0} packages loaded", packages.size());
		return packages;
	}

	public void dispose(@Disposes List<TourPackage> packages) {
		logger.log(Level.INFO, "Disposing produced tour package list: {0} elements in the list", packages.size());
	}
}
