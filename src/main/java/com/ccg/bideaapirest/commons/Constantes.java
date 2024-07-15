package com.ccg.bideaapirest.commons;

public class Constantes {
	// RUTAS URI
	public static final String URI_CODIGO_DESCUENTO = "https://sbv2bumkomidlxwffpgbh4k6jm0ydskh.lambda-url.us-east-1.on.aws/";
	
	// CAMPOS REQUEST BODY APIREST DISCOUNTCODE
	public static final String USER_ID = "userId";
	public static final String HOUSE_ID = "houseId";
	public static final String DISCOUNT_CODE = "discountCode";

	// CODIGOS HTTP 
	public static final int HTTP_OK = 200;
	public static final int HTTP_BAD_REQUEST = 400;
	public static final int HTTP_BAD_CONFLICT = 409;
	public static final int HTTP_INTERNAL_SERVER_ERROR = 500;
}
