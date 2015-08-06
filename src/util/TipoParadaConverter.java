package util;

import java.util.Collection;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import DAO.Interface.TipoParadaDAO;
import entity.TipoParada;

@FacesConverter(forClass = TipoParada.class)
@Named
@Getter
@Setter
public class TipoParadaConverter implements Converter {

	@Inject
	private TipoParadaDAO tipoParadaDAO;

	public TipoParadaConverter() {
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		System.out.println("Get as object");
		Collection<TipoParada> tipoParadas = (List<TipoParada>) tipoParadaDAO
				.findAll(TipoParada.class.getName());
		long id;

		System.out.println("2222222222222222222222222222222222" + arg2);

		id = Long.valueOf(arg2);
		for (TipoParada tipoParada : tipoParadas) {
			if (tipoParada.getIdTipoParada() == id) {
				return tipoParada;
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null) {
			return "";
		}

		TipoParada tipoParada = (TipoParada) arg2;
		System.out.println("------------------------"
				+ tipoParada.getIdTipoParada());
		return String.valueOf(tipoParada);
	}

}
