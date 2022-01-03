package org.uoc.pds.alpha.cultureindahouse.front.category;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListCategoriesMB")
public class ListCategoriesMB {

	@EJB
	private AdministrationLocal categoryLocal;

	public List<CategoryVO> getCategories() {
		return categoryLocal.listAllCategories();
	}


	public List<SelectItem> getFilterTypes() {
		List<SelectItem> filterTypes = new ArrayList<>();

		for (CategoryVO cat : getCategories()) {
			filterTypes.add(new SelectItem(cat.getId(), cat.getName()));

		}

		return filterTypes;
	}

	public String listCategories() {
		return "listCategoryView.xhtml";
	}

	public String listEvents() {
		return "listEventView.xhtml";
	}

	public String Administration() {
		return "administrationView.xhtml";
	}

	public String SuperAdministration() {
		return "superAdministrationView.xhtml";
	}

	public String errorAdministration() {
		return "ErrorView.xhtml";
	}

	public String errorEvent() {
		return "event/ErrorView.xhtml";
	}

	public String errorMedia() {
		return "media/ErrorView.xhtml";
	}

	public String errorProfile() {
		return "private/ErrorView.xhtml";
	}

}
