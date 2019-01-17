package com.pcdgroup.cms.PcdEcom.Order;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdermasterRepository extends CrudRepository<Ordermaster, Integer> {
	
	@Query(nativeQuery = true, value = "Select orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid from  ordermaster WHERE rid = ?1 ORDER BY orderid DESC LIMIT 0, 10")
	List<Ordermaster> getAllOrders(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT orderid FROM ordermaster ORDER BY orderid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM ordermaster WHERE orderid = ?1 AND rid = ?2")
	void cancleOrder(Integer orderid, Integer userid);
	
	@Query(nativeQuery = true, value = "SELECT orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid from  ordermaster "
			+ "WHERE LOWER(trim(orderstatus)) = LOWER(trim('pending')) LIMIT ?1, 6")
	List<Ordermaster> getAllPendingorders(Integer startindx);
	
}
