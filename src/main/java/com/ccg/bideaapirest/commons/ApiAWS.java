package com.ccg.bideaapirest.commons;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ccg.bideaapirest.model.Booking;

public class ApiAWS {
	public static HttpResponse<?> invocarApiDiscountCode(Booking booking) throws URISyntaxException {
		Logger log = LoggerFactory.getLogger(ApiAWS.class);
		
		HttpClient client = HttpClient.newBuilder().build();
		
		String json = new StringBuilder().append("{")
				.append("\"" + Constantes.USER_ID + "\":\"" + booking.getId() + "\",")
				.append("\"" + Constantes.HOUSE_ID + "\":\"" + booking.getHouseId() + "\",")
				.append("\"" + Constantes.DISCOUNT_CODE + "\":\"" + booking.getDiscountCode() + "\"").append("}")
				.toString();

		HttpRequest request = HttpRequest.newBuilder().header("Content-Type", "application/json")
				.uri(new URI(Constantes.URI_CODIGO_DESCUENTO)).POST(HttpRequest.BodyPublishers.ofString(json)).build();
		HttpResponse<?> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			log.error("IOException | InterruptedException", e.getMessage());
		}
		return response;
		

	}
}
