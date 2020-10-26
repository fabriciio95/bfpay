package br.com.bluefood.bfpay.service;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluefood.bfpay.domain.Cartao;
import br.com.bluefood.bfpay.domain.PaymentResponse;

@RestController
public class BFPayService {

	@PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentResponse> pagar(
			@RequestHeader("Token") String token,
			@Valid @RequestBody Cartao cartao,
			Errors erros) {
		
		return null;
		
	}
}
