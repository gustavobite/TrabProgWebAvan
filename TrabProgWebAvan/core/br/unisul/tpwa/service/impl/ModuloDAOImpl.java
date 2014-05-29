package br.unisul.tpwa.service.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.unisul.tpwa.entity.Modulo;
import br.unisul.tpwa.service.ModuloDAO;

@Stateless
public class ModuloDAOImpl extends GenericoDAOImpl<Modulo> implements ModuloDAO {

	@Override
	public List<Modulo> listar(Map<String, Object> params) {
		Modulo entidadeFiltro = (Modulo) params.get("entidadeFiltro");

		String titulo = entidadeFiltro.getTitulo() != null ? entidadeFiltro.getTitulo() : "";
		
		return em.createQuery("from Modulo where titulo like :titulo order by titulo", Modulo.class)
				.setParameter("titulo", "%" + titulo + "%")
				.getResultList();
	}

}