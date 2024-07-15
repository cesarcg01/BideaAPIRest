package com.ccg.bideaapirest.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccg.bideaapirest.commons.ApiAWS;
import com.ccg.bideaapirest.commons.Constantes;
import com.ccg.bideaapirest.model.Booking;
import com.ccg.bideaapirest.response.BookResponse;
import com.ccg.bideaapirest.response.ErrorResponse;
import com.ccg.bideaapirest.service.IBookingService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/bideafactory")
public class BookingController {
	@Autowired
	private IBookingService bookingService;

	private final Logger log = LoggerFactory.getLogger(BookingController.class);

	@PostMapping("/book")
	public ResponseEntity<?> grabarBook(@Validated @RequestBody Booking booking, BindingResult result)
			throws URISyntaxException, IOException, InterruptedException {
		log.info("Inicio grabarBook ");
		BookResponse bookResponse = new BookResponse();
		ErrorResponse errorResponse = new ErrorResponse();

		if (result.hasErrors()) {

			List<FieldError> errors = result.getFieldErrors();
			for (FieldError error : errors) {

				errorResponse.setStatusCode(Constantes.HTTP_BAD_REQUEST);
				errorResponse.setError(error.getField());
				errorResponse.setMessage(error.getDefaultMessage());
			}

			return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {

			try {
				if (booking.getDiscountCode() == null) {
					booking.setDiscountCode("");
				}
				if (!booking.getDiscountCode().isEmpty()) {

					HttpResponse<?> response = ApiAWS.invocarApiDiscountCode(booking);
					if (response != null && response.statusCode() == Constantes.HTTP_OK) {
						JsonObject jsonObject = JsonParser.parseString(response.body().toString()).getAsJsonObject();
						if (jsonObject.get("status").getAsString().equals("true")) {
							Booking saveBook= bookingService.saveBooking(booking);
							log.info("Reserva guardada id:",saveBook.getId());
							log.debug("Reserva guardada id:",saveBook.getId());
							bookResponse.setCode(Constantes.HTTP_OK);
							bookResponse.setMessage("Book Accepted");
						} else if (jsonObject.get("status").getAsString().equals("false")) {
							errorResponse.setStatusCode(Constantes.HTTP_BAD_CONFLICT);
							errorResponse.setError("Conflict");
							errorResponse.setMessage("Invalid discount");
							return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
						}
					}
					if (response != null && response.statusCode() == Constantes.HTTP_BAD_REQUEST) {
						JsonObject jsonObject = JsonParser.parseString(response.body().toString()).getAsJsonObject();
						errorResponse.setStatusCode(Constantes.HTTP_BAD_REQUEST);
						errorResponse.setError("Bad Request");
						errorResponse.setMessage(jsonObject.get("message").getAsString());
						return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
					}if(response == null){
						errorResponse.setStatusCode(Constantes.HTTP_BAD_REQUEST);
						errorResponse.setError("Server Error");
						errorResponse.setMessage("Sin conexión al Api");
						return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
					}
					
				} else {
					Booking saveBook= bookingService.saveBooking(booking);
					log.info("Reserva guardada id:",saveBook.getId());
					log.debug("Reserva guardada id:",saveBook.getId());
					bookResponse.setCode(Constantes.HTTP_OK);
					bookResponse.setMessage("Book Accepted");
				}

			} catch (DataAccessException e) {
				String str = "Error al realizar el insert en la base de datos"
						+ e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage());
				errorResponse.setStatusCode(Constantes.HTTP_INTERNAL_SERVER_ERROR);
				errorResponse.setError("Internal Server Error");
				errorResponse.setMessage(str.toString());
				log.error(e.getMessage());
				return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			log.info("Fin grabarBook ");
			return new ResponseEntity<BookResponse>(bookResponse, HttpStatus.CREATED);
		}
	}

}
