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
import br.com.bluefood.bfpay.enums.StatusPagamento;

@RestController
public class BFPayService {
	
	private static final String AUTH_TOKEN = "r2d2";

	@PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentResponse> pagar(
			@RequestHeader("Token") String token,
			@Valid @RequestBody Cartao cartao,
			Errors errors) {
		
		if(!AUTH_TOKEN.equals(token)) {
			return ResponseEntity.badRequest().body(new PaymentResponse("Token inválido!"));
		}
		
		if(errors.hasErrors()) {
			return ResponseEntity.ok(new PaymentResponse(StatusPagamento.CartaoInvalido));
		}
		
		String numCartao = cartao.getNumCartao();
		
		StatusPagamento status;
		
		if(numCartao.startsWith("0000") || numCartao.startsWith("1111") || numCartao.startsWith("2222") || numCartao.startsWith("3333")) {
			status = StatusPagamento.Autorizado;
		} else {
			status = StatusPagamento.NaoAutorizado;
		}
	
		return ResponseEntity.ok(new PaymentResponse(status));
		
	}
}
