package br.unisul.tpwa.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unisul.tpwa.entity.Entidade;
import br.unisul.tpwa.service.GenericoDAO;

public abstract class GenericoDAOImpl<T extends Entidade> implements GenericoDAO<T> {
	
	@PersistenceContext(unitName="TPWA")
	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericoDAOImpl() {
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(T entidade) {
		if (entidade.getId() == null) {
			em.persist(entidade);
		} else {
			em.merge(entidade);
		}
	}

	public void excluir(T entidade) {
		em.remove(buscar(entidade.getId()));
		em.flush();
	}

	public T buscar(Object codigo) {
		return em.find(clazz, codigo);
	}

	public List<T> listar() {
		return em.createQuery("from "+ clazz.getSimpleName(), clazz).getResultList();
	}
	
	public abstract List<T> listar(Map<String, Object> params);

}