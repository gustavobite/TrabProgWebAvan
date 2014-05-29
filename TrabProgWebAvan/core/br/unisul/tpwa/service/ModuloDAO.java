package br.unisul.tpwa.service;

import javax.ejb.Local;

import br.unisul.tpwa.entity.Modulo;
import br.unisul.tpwa.entity.Pessoa;

@Local
public interface ModuloDAO extends GenericoDAO<Modulo> {
	
}