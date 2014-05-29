package br.unisul.tpwa.entity.enums;


public enum DivisaoLogica {

	SENAMAL(1L, "Divisão semanal"),
	QUINZENAL(2L, "Divisão quinzenal"),
	MENSAL(3L, "Divisão mensal"),
	TOPICO(4L, "Divisão por tópico");
	
	private Long codigo;
	private String nome;

	private DivisaoLogica(Long codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public DivisaoLogica[] getValues() {
		return DivisaoLogica.values();
	}
}
