package br.unisul.tpwa.service.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.unisul.tpwa.entity.Curso;
import br.unisul.tpwa.entity.Modulo;
import br.unisul.tpwa.entity.Topico;
import br.unisul.tpwa.service.CursoDAO;
import br.unisul.tpwa.service.ModuloDAO;
import br.unisul.tpwa.service.TopicoDAO;

@Stateless
public class TopicoDAOImpl extends GenericoDAOImpl<Topico> implements TopicoDAO {

	@Override
	public List<Topico> listar(Map<String, Object> params) {
		Topico entidadeFiltro = (Topico) params.get("entidadeFiltro");
		
		String nome = entidadeFiltro.getNome() != null ? entidadeFiltro.getNome() : "";
		
		return em.createQuery("from Topico where nome like :nome order by nome", Topico.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

}