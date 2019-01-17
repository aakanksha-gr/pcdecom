package com.pcdgroup.cms.PcdEcom.Order;

import java.util.List;

public interface OrderService {

	public List<?> getAllOrders(Integer id);
	public String addOrder(Ordermaster ordermaster, Integer id);
	public List<?> getAllPendingorders(Integer index);
	public String cancleOrder(Integer orderid, Integer userid);
	
}
