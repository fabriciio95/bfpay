package br.com.bluefood.bfpay.domain;

import br.com.bluefood.bfpay.enums.StatusPagamento;

public class PaymentResponse {

	private StatusPagamento status;
	private String error;

	public PaymentResponse(StatusPagamento status) {
		this.status = status;
	}

	public PaymentResponse(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public StatusPagamento getStatus() {
		return status;
	}
}
