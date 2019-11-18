package com.customer.app.commons;

public interface DBQueries {
	String SELECT_ALL_CUSTMR = "SELECT ID, NAME, DESCRIPTION, CREATEDATE, CREATEDUSER, LASTMODIFIED, UPDATEDUSER FROM CUSTOMER";
	String SELECT_CUSTMR_ID = "";
	String INSERT_CUSTMR = "";
	String UPDTE_CUSTMR_BY_ID = "";
	String DELTE_CUSTMR_BY_ID = "";
}
