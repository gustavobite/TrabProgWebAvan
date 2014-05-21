package br.unisul.tpwa.mb;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unisul.tpwa.entity.Pessoa;
import br.unisul.tpwa.service.PessoaDAO;

@ManagedBean
@ViewScoped
public class PessoaMB extends ManterMB<Pessoa, PessoaDAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PessoaDAO pessoaDAO;
	
	@Override
	protected PessoaDAO getDAO() {
		return pessoaDAO;
	}
	
}