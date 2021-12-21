package org.uoc.pds.alpha.cultureindahouse.front;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
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

	public String detailCategories() {
		return "categoryDetailView.xhtml";
	}
	public String Administration() { return "administrationView.xhtml"; }

	public String errorAdministration() { return "error.xhtml"; }
	public String errorEvent() { return "event/error.xhtml"; }
	public String errorMedia() { return "media/error.xhtml"; }
	public String errorProfile() { return "private/error.xhtml"; }




}
