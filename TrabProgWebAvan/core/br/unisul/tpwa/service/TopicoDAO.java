package br.unisul.tpwa.service;

import javax.ejb.Local;

import br.unisul.tpwa.entity.Topico;

@Local
public interface TopicoDAO extends GenericoDAO<Topico> {
	
}