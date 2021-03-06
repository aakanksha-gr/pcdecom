package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcdproducttaskRepository extends CrudRepository<Pcdproducttaskmaster, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT pcdproducttaskid FROM pcdproducttaskmaster ORDER BY pcdproducttaskid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT pcdproducttaskid, pcdpid, tid FROM pcdproducttaskmaster WHERE pcdproducttaskid = ?1")
	Pcdproducttaskmaster getPcdproductTask(Integer pcdproducttaskid);
	
	@Query(nativeQuery = true, value = "SELECT pcdproducttaskid, pcdpid, tid FROM pcdproducttaskmaster")
	List<Pcdproducttaskmaster> getAllPcdproductTask();
	
}
