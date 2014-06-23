package br.unisul.tpwa.mb;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;

import br.unisul.tpwa.entity.Curso;
import br.unisul.tpwa.entity.Modulo;
import br.unisul.tpwa.entity.Topico;
import br.unisul.tpwa.entity.enums.DivisaoLogica;
import br.unisul.tpwa.service.CursoDAO;
import br.unisul.tpwa.service.ModuloDAO;
import br.unisul.tpwa.service.TopicoDAO;

@ManagedBean
@ViewScoped
public class ModuloMB extends ManterMB<Modulo, ModuloDAO> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ModuloDAO moduloDAO;
	
	@EJB
	private CursoDAO cursoDAO;
	
	@EJB
	private TopicoDAO topicoDAO;
	
	private DualListModel<Topico> topicos;
	
	private List<Topico> topicosEscolhidos = new ArrayList<Topico>();
	
	private InputStream arquivo;
	
//	@PostConstruct
//    public void init() {
//		topicos = new DualListModel<Topico>(getTopicos(), topicosEscolhidos);
//    }
	
	@Override
	protected ModuloDAO getDAO() {
		return moduloDAO;
	}
	
	@Override
	public void irParaCadastro() {
		super.irParaCadastro();
		
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile(); 
		String fileNameUploaded = uploadedFile.getFileName(); 
		long fileSizeUploaded = uploadedFile.getSize(); 
		try {
			InputStream fileInputStream = uploadedFile.getInputstream();
			
		} catch (IOException e) {
			onErro(new Exception("Houver algum erro ao tentar carregar o arquivo."));
		}
    }
	
	public List<SelectItem> getDivisoesLogicas() {
		List<SelectItem> divisoesLogicas = new ArrayList<SelectItem>();
		for (DivisaoLogica dl : DivisaoLogica.values()) {
			divisoesLogicas.add(new SelectItem(dl.name(), dl.getNome()));
		}
		return divisoesLogicas;
	}
	
	@Override
	protected void onAntesSalvar() throws Exception {
		entidade.setCurso(getCursoSessao());
		entidade.setTopicos(getTopicos());
//		if(entidade.getDivisaoLogica() == DivisaoLogica.TOPICO && !topicosEscolhidos.isEmpty())
//			entidade.setTopicos(topicosEscolhidos);
//		else
//			throw new Exception("Você escolheu a divisão lógica por Tópica, porém não escolheu nenhum dos tópicos. \n Favor selecionar tópicos para relacionar ao módulo!");
	}

	//
	private Curso getCursoSessao() {
		return cursoDAO.listar().get(0);
	}
	
	public List<Topico> getTopicos() {
		return topicoDAO.listar();
	}

	public void setTopicos(DualListModel<Topico> topicos) {
		this.topicos = topicos;
	}

	public List<Topico> getTopicosEscolhidos() {
		return topicosEscolhidos;
	}

	public void setTopicosEscolhidos(List<Topico> topicosEscolhidos) {
		this.topicosEscolhidos = topicosEscolhidos;
	}
	
}