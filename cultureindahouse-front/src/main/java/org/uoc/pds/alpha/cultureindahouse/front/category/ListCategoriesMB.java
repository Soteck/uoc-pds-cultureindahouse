package org.uoc.pds.alpha.cultureindahouse.front.category;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListCategoriesMB")
public class ListCategoriesMB {

	@EJB
	private AdministrationLocal categoryLocal;

	public List<CategoryVO> getCategories() {
		return categoryLocal.listAllCategories();
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
