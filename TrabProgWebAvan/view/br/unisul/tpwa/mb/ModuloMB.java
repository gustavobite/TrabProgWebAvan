package br.unisul.tpwa.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.unisul.tpwa.entity.Modulo;
import br.unisul.tpwa.entity.Pessoa;
import br.unisul.tpwa.entity.enums.DivisaoLogica;
import br.unisul.tpwa.service.ModuloDAO;
import br.unisul.tpwa.service.PessoaDAO;

@ManagedBean
@ViewScoped
public class ModuloMB extends ManterMB<Modulo, ModuloDAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ModuloDAO moduloDAO;
	
	@Override
	protected ModuloDAO getDAO() {
		return moduloDAO;
	}
	
	public List<SelectItem> getDivisoesLogicas() {
		List<SelectItem> divisoesLogicas = new ArrayList<SelectItem>();
		for (DivisaoLogica dl : DivisaoLogica.values()) {
			divisoesLogicas.add(new SelectItem(dl.name(), dl.getNome()));
		}
		return divisoesLogicas;
	}
	
}