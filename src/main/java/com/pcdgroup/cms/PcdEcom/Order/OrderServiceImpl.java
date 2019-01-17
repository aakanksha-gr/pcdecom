package com.pcdgroup.cms.PcdEcom.Order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.RegistrationServiceImpl;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrdermasterRepository ordermasterRepository;
	
	@Autowired
	RegistrationServiceImpl registrationServiceImpl; 
	
	@Override
	public List<?> getAllOrders(Integer id) {
		List<Ordermaster> orderList;
		
		try {
			
			orderList = new ArrayList<>();
			if(null != String.valueOf(id)) {
				
				orderList = ordermasterRepository.getAllOrders(id);
				
				if(null != orderList && orderList.size() > 0) {
					
					return orderList;
				
				} else {
					
					System.out.println("No more records are avilable..!");
					
				}
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
	
		}
		
		return null;
	
	}

	@Override
	public String addOrder(Ordermaster ordermaster, Integer id) {
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
				if(null == ordermasterRepository.getMaxId()) {
				
					ordermaster.setOid(1);
				
				} else {
				
					ordermaster.setOid(ordermasterRepository.getMaxId()+1);
		
				}
			
				ordermaster.setRid(id);
				
				ordermaster.setDatetime(calobj.getTime());
				
				ordermasterRepository.save(ordermaster);
			
				return "Ordered successful..!";
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
	
		return "Something wents wrong..!";
		
	}

	@Override
	public List<?> getAllPendingorders(Integer index) {
		
		try {
			
			if(null != ordermasterRepository.getAllPendingorders(index) && ordermasterRepository.getAllPendingorders(index).size() > 0) {
				
				return ordermasterRepository.getAllPendingorders(index);
				
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public String cancleOrder(Integer orderid, Integer userid) {
		
		try {
			
			if(null != orderid && null != userid) {
				
				ordermasterRepository.cancleOrder(orderid, userid);
				
				return "Your order cancelled..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	public void readList(Ordermaster ordermaster) {
		
		System.out.println("List==> "+ordermaster.getOrderlist());
		
	}
	
}
