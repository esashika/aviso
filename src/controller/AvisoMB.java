package controller;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;
import DAO.Interface.AvisoDAO;
import DAO.Interface.TipoParadaDAO;
import entity.Aviso;
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

	@Inject
	AvisoDAO avisoDAO;

	@Inject
	TipoParadaDAO tipoParadaDAO;

	@Inject
	Aviso aviso;

	@PostConstruct
	public void init() {
		findAll();
		findAllTipoParada();

	}

	private List<Aviso> listaDeAvisos = new ArrayList<>();
	private List<TipoParada> listaTipoParada = new ArrayList<>();

	public List<Aviso> findAll() {
		listaDeAvisos = (List<Aviso>) avisoDAO.findAll(Aviso.class.getName());
		return listaDeAvisos;
	}

	public String save() {

		aviso.setDataEvento(new Date());
		aviso.setDataRetorno(new Date());
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

}
