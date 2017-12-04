package br.ufes.inf.nemo.dev.cditravel.persistence;

import br.ufes.inf.nemo.dev.cditravel.domain.TourPackage;
import br.ufes.inf.nemo.dev.util.BaseDAO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface TourPackageDAO extends BaseDAO<TourPackage> {
	List<TourPackage> findByName(String name);
 }
