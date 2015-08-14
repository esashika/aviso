package controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import DAO.Interface.AvisoDAO;
import DAO.Interface.SistemaDAO;
import DAO.Interface.TipoParadaDAO;
import entity.Aviso;
import entity.Sistema;
import entity.TipoParada;

@SessionScoped
@Getter
@Setter
@ManagedBean
public class AvisoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String dataEvento;
	String dataRetorno;
	String idSistema;

	@Inject
	AvisoDAO avisoDAO;

	@Inject
	TipoParadaDAO tipoParadaDAO;

	@Inject
	SistemaDAO sistemaDAO;

	@Inject
	Aviso aviso;

	@PostConstruct
	public void init() {
		listaDeAvisos = findAll();
		findAllTipoParada();
		findAllSistema();
		listAllPJE=findAllPJESystem();
		listAllProjudi = findAllProjudiSystem();

	}

	private List<Aviso> listaDeAvisos = new ArrayList<>();
	private List<Aviso> listAllPJE = new ArrayList<>();
	private List<Aviso> listAllProjudi = new ArrayList<>();
	private List<TipoParada> listaTipoParada = new ArrayList<>();
	private List<Sistema> listaTipoSistema = new ArrayList<>();

	public List<Aviso> findAll() {
		listaDeAvisos = (List<Aviso>) avisoDAO.findAll(Aviso.class.getName());
		return listaDeAvisos;
	}

	public String save() {
		System.out.println(aviso.getTipoParada().getDescparada());
		avisoDAO.persist(aviso);
		aviso = new Aviso();
		return "homeadm.xhtml";
	}

	public String update() {
		avisoDAO.merge(aviso);
		aviso = new Aviso();
		return "homeadm.xhtml";
	}

	public void delete() {
		avisoDAO.remove(aviso);
		findAll();
		aviso = new Aviso();
	}

	public List<TipoParada> findAllTipoParada() {
		listaTipoParada = (List<TipoParada>) tipoParadaDAO
				.findAll(TipoParada.class.getName());
		return listaTipoParada;
	}

	public List<Sistema> findAllSistema() {
		listaTipoSistema = (List<Sistema>) sistemaDAO.findAll(Sistema.class
				.getName());
		return listaTipoSistema;
	}

	public List<Aviso> findAllPJESystem() {
		listAllPJE = avisoDAO.findAllByIdSystem("2");
		return listAllPJE;
	}

	public List<Aviso> findAllProjudiSystem(){
		listAllProjudi = avisoDAO.findAllByIdSystem("1");
		return listAllProjudi;
	}
	
	public List<Aviso> pesquisarPorData() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(aviso.getDataEvento());

		String dataEvento = df.format(aviso.getDataEvento());
		System.out.println(dataEvento);

		String dataRetorno = df.format(aviso.getDataRetorno());
		System.out.println(dataRetorno);

		listaDeAvisos = avisoDAO.SearchAvisoByDateEventoAndDateReturn(
				dataEvento, dataRetorno);

		return listaDeAvisos;

	}
	
	public List<Aviso> pesquisarPorDataPJE() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(aviso.getDataEvento());

		String dataEvento = df.format(aviso.getDataEvento());
		System.out.println(dataEvento);

		String dataRetorno = df.format(aviso.getDataRetorno());
		System.out.println(dataRetorno);

		listAllPJE = avisoDAO.SearchAvisoByDateEventoAndDateReturnIdSystem(
				dataEvento, dataRetorno, "2");

		return listAllPJE;

	}

	public List<Aviso> pesquisarPorDataProjudi() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(aviso.getDataEvento());

		String dataEvento = df.format(aviso.getDataEvento());
		System.out.println(dataEvento);

		String dataRetorno = df.format(aviso.getDataRetorno());
		System.out.println(dataRetorno);

		listAllProjudi = avisoDAO.SearchAvisoByDateEventoAndDateReturnIdSystem(
				dataEvento, dataRetorno, "1");

		return listAllProjudi;

	}

	
}
