package br.unisul.tpwa.mb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.unisul.tpwa.entity.Entidade;
import br.unisul.tpwa.service.GenericoDAO;

public abstract class ManterMB<E extends Entidade, DAO extends GenericoDAO<E>> extends GenericoMB<E, DAO> {

	protected E entidadeFiltro;
	protected Map<String, Object> params;
	protected List<E> lista;
	private boolean pesquisa;
	
	@PostConstruct
	private void iniciar(){
		this.entidadeFiltro = criarInstanciaEntidade();
		this.params = new HashMap<String, Object>();
		
		irParaPesquisa();
	}

	public void pesquisar(){
		params.put("entidadeFiltro", entidadeFiltro);

		onAntesPesquisar();
		
		lista = dao.listar(params);
	}
	
	public void salvar(){
		try{
			onAntesSalvar();
			
			dao.salvar(entidade);
			
			onAposSalvar();
			
			prepararEntidade();
			
			onSalvoSucesso();
			
			irParaPesquisa();
		}catch (Exception e) {
			onErro(e);
		}
	}

	public void excluir(){
		try{
			dao.excluir(entidade);
			
			onExcluidoSucesso();
			
			pesquisar();
		}catch (Exception e) {
			onErro(e);
		}
	}
	
	protected void onAntesPesquisar() {}
	
	protected void onAntesSalvar() throws Exception {}
	
	protected void onAposSalvar() {}
	
	protected void onSalvoSucesso(){
		onMessagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", null));
	}
	
	protected void onExcluidoSucesso(){
		onMessagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com sucesso!", null));
	}
	
	protected void onAtualizadoSucesso(){
		onMessagem(new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizado com sucesso!", null));
	}
	
	protected void onErro(Exception e){
		onMessagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu um erro inesperado", "Motivo: " + e.getMessage()));
	}
	
	protected final void onMessagem(FacesMessage facesMessage) {
		onMessagem(null, facesMessage);
	}
	
	protected final void onMessagem(String clientId, FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(clientId, facesMessage);
	}
	
	public void irParaPesquisa(){
		prepararEntidade();
		entidadeFiltro = criarInstanciaEntidade();
		pesquisar();
		setPesquisa(true);
	}
	
	public void irParaCadastro(){
		prepararEntidade();
		setPesquisa(false);
	}
	
	public void irParaEdicao(E entidade){
		prepararEntidade(entidade);
		setPesquisa(false);
	}
	
	public E getEntidadeFiltro() {
		return entidadeFiltro;
	}

	public void setEntidadeFiltro(E entidadeFiltro) {
		this.entidadeFiltro = entidadeFiltro;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public List<E> getLista() {
		return lista;
	}

	public void setLista(List<E> lista) {
		this.lista = lista;
	}

	public boolean isPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(boolean pesquisa) {
		this.pesquisa = pesquisa;
	}

}