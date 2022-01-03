package org.uoc.pds.alpha.cultureindahouse.front.EventOrganizer;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListEventOrganizerMB")
public class ListEventOrganizerMB {

	@EJB
	private AdministrationLocal eventOrganizerLocal;

	public List<EventOrganizerVO> getEventOrganizer() {
		return eventOrganizerLocal.listAllEventOrganizers();
	}

	public List<SelectItem> getFilterTypes() {
		List<SelectItem> filterTypes = new ArrayList<>();

		for (EventOrganizerVO eo : getEventOrganizer()) {
			filterTypes.add(new SelectItem(eo.getId(), eo.getName()));

		}

		return filterTypes;
	}


	public String listEventOrganizers() {
		return "EventOrganizerListView.xhtml";
	}

	public String Administration() {
		return "administrationView.xhtml";
	}

	public String errorLabel() {
		return "ErrorView.xhtml";
	}

}
