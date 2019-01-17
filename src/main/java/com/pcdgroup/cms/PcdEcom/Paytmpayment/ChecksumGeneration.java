package com.pcdgroup.cms.PcdEcom.Paytmpayment;

import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.paytm.pg.merchant.CheckSumServiceHelper;

@Service
public class ChecksumGeneration {
	
	//Below parameters provided by Paytm
	private static String MercahntKey = "XXXXXXXXXXXXXXXX";
	/*private static String MID = "XXXXXXXXXXXXXXXXXXXXXXXX"; 
	;
	private static String INDUSTRY_TYPE_ID = "XXXXXXXXXXXX";
	private static String CHANNLE_ID = "WAP";
	private static String WEBSITE = "XXXXXXXXXX";
	private static String CALLBACK_URL = "XXXXXXXXXXXXXX";*/
		
	public TreeMap<String, String> GenerateChecksum(ChecksumGenerationBean checksumGenerationBean) {
		
		System.out.println(checksumGenerationBean.getMID());
		
		TreeMap<String,String> paramMap = new TreeMap<String,String>();
		paramMap.put("MID" , checksumGenerationBean.getMID());
		paramMap.put("ORDER_ID" , checksumGenerationBean.getORDER_ID());
		paramMap.put("CUST_ID" , checksumGenerationBean.getCUST_ID());
		paramMap.put("INDUSTRY_TYPE_ID" , checksumGenerationBean.getINDUSTRY_TYPE_ID());
		paramMap.put("CHANNEL_ID" , checksumGenerationBean.getCHANNEL_ID());
		paramMap.put("TXN_AMOUNT" , checksumGenerationBean.getTXN_AMOUNT());
		paramMap.put("WEBSITE" , checksumGenerationBean.getWEBSITE());
		paramMap.put("EMAIL" , checksumGenerationBean.getEMAIL());
		paramMap.put("MOBILE_NO" , checksumGenerationBean.getMOBILE_NO());
		paramMap.put("CALLBACK_URL" , checksumGenerationBean.getCALLBACK_URL());
		
		try{
		String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MercahntKey, paramMap);
		paramMap.put("CHECKSUMHASH" , checkSum);
		
		System.out.println("Paytm Payload: "+ paramMap);
		
		return paramMap;
		
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
		
	}
	
}
