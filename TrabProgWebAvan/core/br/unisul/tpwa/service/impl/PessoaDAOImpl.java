package br.unisul.tpwa.service.impl;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.unisul.tpwa.entity.Pessoa;
import br.unisul.tpwa.service.PessoaDAO;

@Stateless
public class PessoaDAOImpl extends GenericoDAOImpl<Pessoa> implements PessoaDAO {

	@Override
	public List<Pessoa> listar(Map<String, Object> params) {
		Pessoa entidadeFiltro = (Pessoa) params.get("entidadeFiltro");

		String nome = entidadeFiltro.getNome() != null ? entidadeFiltro.getNome() : "";
		
		return em.createQuery("from Pessoa where nome like :nome order by nome", Pessoa.class)
				.setParameter("nome", "%" + nome + "%")
				.getResultList();
	}

}