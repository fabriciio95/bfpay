package br.com.bluefood.bfpay.enums;

public enum StatusPagamento {

	Autorizado("Autorizado"),
	NaoAutorizado("Não autorizado pela instituição financeira"),
	CartaoInvalido("Cartão inválido ou bloqueado");
	
	String descricao;
	
	private StatusPagamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
