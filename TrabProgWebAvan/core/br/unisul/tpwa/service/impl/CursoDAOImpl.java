package br.unisul.tpwa.service.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.unisul.tpwa.entity.Curso;
import br.unisul.tpwa.entity.Modulo;
import br.unisul.tpwa.service.CursoDAO;
import br.unisul.tpwa.service.ModuloDAO;

@Stateless
public class CursoDAOImpl extends GenericoDAOImpl<Curso> implements CursoDAO {

	@Override
	public List<Curso> listar(Map<String, Object> params) {
		Curso entidadeFiltro = (Curso) params.get("entidadeFiltro");
		
		String nome = entidadeFiltro.getNome() != null ? entidadeFiltro.getNome() : "";
		
		return em.createQuery("from Curso where nome like :nome order by nome", Curso.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

}