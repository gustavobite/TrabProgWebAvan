package br.unisul.tpwa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unisul.tpwa.entity.enums.DivisaoLogica;

@Entity
@Table(name="MODULO")
public class Modulo implements Serializable, Entidade{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CD_MODULO")
	private Long id;
	
	@Column(name="DS_TITULO")
	private String titulo;
	
	@Column(name="FG_DISPONIVEL")
	private Boolean permanecerDisponivel;
	
	@Column(name = "DT_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
	private Date dataInicial;
	
	@Column(name = "DT_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;
	
	@Column(name="CD_DIVISAO_LOG")
	@Enumerated(EnumType.ORDINAL)
	private DivisaoLogica divisaoLogica;
	
	@JoinColumn(name = "CD_CURSO", referencedColumnName = "CD_CURSO", nullable = false)
    @ManyToOne(optional = false)
	private Curso curso;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
	private List<Recurso> recursos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "modulo")
	private List<Topico> topicos;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getPermanecerDisponivel() {
		return permanecerDisponivel;
	}

	public void setPermanecerDisponivel(Boolean permanecerDisponivel) {
		this.permanecerDisponivel = permanecerDisponivel;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public DivisaoLogica getDivisaoLogica() {
		return divisaoLogica;
	}

	public void setDivisaoLogica(DivisaoLogica divisaoLogica) {
		this.divisaoLogica = divisaoLogica;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public List<Topico> getTopicos() {
		return topicos;
	}

	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}
	
}
