package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddtocartServiceImpl implements AddtocartService {

	@Autowired
	AddtocartRepository addtocartRepository;
	
	@Override
	public List<?> getCartItems(Integer id) {
		
		List<?> cartList;
		
		try {
			
			cartList = new ArrayList<>();
			
			cartList = addtocartRepository.getAllOrders(id);
			
			if(null != cartList && cartList.size() > 0) {
				return cartList;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@Override
	public List<?> GetCartById(Integer userid) {
		
		List<Addtocartmaster> cartList;
		
		try {
			
			cartList = new ArrayList<>();
			
			cartList = addtocartRepository.getAllCartItems(userid);
			
			if(cartList != null && cartList.size() > 0) {
				return cartList;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String addCart(Addtocartmaster addtocartmaster, Integer id) {
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
			if(null != String.valueOf(id)) {
				
				if(null == addtocartRepository.getMaxId()) {
					addtocartmaster.setAddcartid(1);
				} else {
					addtocartmaster.setAddcartid(addtocartRepository.getMaxId()+1);
				}
				
				if(null != addtocartmaster.getDpid()) {
					
					if(null != addtocartRepository.getExistDartproductItemId(id, addtocartmaster.getDpid())) {
						
						return "Item already added in your cart..!";
						
					} 
					
				}
				
				if(null != addtocartmaster.getDsid()) {
					
					if(null != addtocartRepository.getExistDartserviceItemId(id, addtocartmaster.getDsid())) {
						
						return "Item already added in your cart..!";
						
					}
					
				}
				
				if(null != addtocartmaster.getPpid()) {
					
					if(null != addtocartRepository.getExistPcdproductItemId(id, addtocartmaster.getPpid())) {
						
						return "Item already added in your cart..!";
						
					}
					
				}
				
				if(null != addtocartmaster.getPsid()) {
					
					if(null != addtocartRepository.getExistPcdserviceItemId(id, addtocartmaster.getPsid())) {
						
						return "Item already added in yor cart..!";
						
					}
					
				}
				
				addtocartmaster.setUserid(id);
				addtocartmaster.setDatetime(calobj.getTime());
				addtocartRepository.save(addtocartmaster);
				
				return "Item successfully added into cart..!";
				
			} else {
				
				System.out.println("User id is null..!");
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
 
		return "Something went wrong..!";
		
	}

	public String deleteCartItem(Integer id, Integer itemid) {
		try {
			
			if(null != String.valueOf(id) && null != String.valueOf(itemid)) {
				
				addtocartRepository.deleteCartItem(id, itemid);
				
				return "item removed from the cart";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

}
