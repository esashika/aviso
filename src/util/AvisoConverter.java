package util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import DAO.Interface.AvisoDAO;
import entity.Aviso;

@FacesConverter(value = "avisoconv")
@Named
@Getter
@Setter
public class AvisoConverter implements Converter {

	@Inject
	private AvisoDAO avisoDAO;

	public AvisoConverter() {
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		System.out.println("Get As object Aviso");
		List<Aviso> avisos = (List<Aviso>) avisoDAO.findAll(Aviso.class
				.getName());
		long id;

		id = Long.valueOf(arg2);
		for (Aviso a : avisos) {
			if (a.getIdAviso() == id) {
				return a;
			}
		}

		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 == null) {
			return "";
		}
		Aviso aviso = (Aviso) arg2;
		System.out.println(aviso);
		return String.valueOf(aviso.getIdAviso());
	}


}
