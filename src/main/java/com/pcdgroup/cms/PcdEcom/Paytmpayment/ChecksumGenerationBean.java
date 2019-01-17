package com.pcdgroup.cms.PcdEcom.Paytmpayment;

public class ChecksumGenerationBean {
	
	String MID;
	String ORDER_ID;
	String CUST_ID;
	String INDUSTRY_TYPE_ID;
	String CHANNEL_ID;
	String TXN_AMOUNT;
	String WEBSITE;
	String CALLBACK_URL;
	String EMAIL;
	String MOBILE_NO;
	
	 
	public ChecksumGenerationBean() {
		super();
	}

	public ChecksumGenerationBean(String mID, String oRDER_ID, String cUST_ID, String iNDUSTRY_TYPE_ID,
			String cHANNEL_ID, String tXN_AMOUNT, String wEBSITE, String cALLBACK_URL, String eMAIL, String mOBILE_NO) {
		super();
		MID = mID;
		ORDER_ID = oRDER_ID;
		CUST_ID = cUST_ID;
		INDUSTRY_TYPE_ID = iNDUSTRY_TYPE_ID;
		CHANNEL_ID = cHANNEL_ID;
		TXN_AMOUNT = tXN_AMOUNT;
		WEBSITE = wEBSITE;
		CALLBACK_URL = cALLBACK_URL;
		EMAIL = eMAIL;
		MOBILE_NO = mOBILE_NO;
	}

	public String getMID() {
		return MID;
	}

	public void setMID(String mID) {
		MID = mID;
	}

	public String getORDER_ID() {
		return ORDER_ID;
	}

	public void setORDER_ID(String oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}

	public String getCUST_ID() {
		return CUST_ID;
	}

	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}

	public String getINDUSTRY_TYPE_ID() {
		return INDUSTRY_TYPE_ID;
	}

	public void setINDUSTRY_TYPE_ID(String iNDUSTRY_TYPE_ID) {
		INDUSTRY_TYPE_ID = iNDUSTRY_TYPE_ID;
	}

	public String getCHANNEL_ID() {
		return CHANNEL_ID;
	}

	public void setCHANNEL_ID(String cHANNEL_ID) {
		CHANNEL_ID = cHANNEL_ID;
	}

	public String getTXN_AMOUNT() {
		return TXN_AMOUNT;
	}

	public void setTXN_AMOUNT(String tXN_AMOUNT) {
		TXN_AMOUNT = tXN_AMOUNT;
	}

	public String getWEBSITE() {
		return WEBSITE;
	}

	public void setWEBSITE(String wEBSITE) {
		WEBSITE = wEBSITE;
	}

	public String getCALLBACK_URL() {
		return CALLBACK_URL;
	}

	public void setCALLBACK_URL(String cALLBACK_URL) {
		CALLBACK_URL = cALLBACK_URL;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getMOBILE_NO() {
		return MOBILE_NO;
	}

	public void setMOBILE_NO(String mOBILE_NO) {
		MOBILE_NO = mOBILE_NO;
	}
		
}
