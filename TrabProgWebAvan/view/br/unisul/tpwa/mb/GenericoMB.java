package br.unisul.tpwa.mb;

import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;

import br.unisul.tpwa.entity.Entidade;
import br.unisul.tpwa.service.GenericoDAO;

public abstract class GenericoMB<E extends Entidade, DAO extends GenericoDAO<E>> {
	
	protected Class<E> clazz;
	
	protected E entidade;
	
	protected DAO dao;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	private void iniciar(){
		this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		this.dao = getDAO();
		
		prepararEntidade();
	}

	protected E criarInstanciaEntidade() {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void prepararEntidade() {
		prepararEntidade(criarInstanciaEntidade());
	}
	
	public void prepararEntidade(E entidade) {
		this.entidade = entidade;
	}
	
	protected abstract DAO getDAO();
	
	public E getEntidade() {
		return entidade;
	}

	public void setEntidade(E entidade) {
		this.entidade = entidade;
	}

}