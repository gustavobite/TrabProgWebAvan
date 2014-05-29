package br.unisul.tpwa.entity.enums;


public enum DivisaoLogica {

	SENAMAL(1L, "Divis�o semanal"),
	QUINZENAL(2L, "Divis�o quinzenal"),
	MENSAL(3L, "Divis�o mensal"),
	TOPICO(4L, "Divis�o por t�pico");
	
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
