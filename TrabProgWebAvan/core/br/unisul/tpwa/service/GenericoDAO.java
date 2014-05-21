package br.unisul.tpwa.service;

import java.util.List;
import java.util.Map;

import br.unisul.tpwa.entity.Entidade;

public interface GenericoDAO<T extends Entidade> {
	
	public void salvar(T entidade);
	
	public void excluir(T entidade);

	public List<T> listar();

	public T buscar(Object codigo);

	public List<T> listar(Map<String, Object> params);

}