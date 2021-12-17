package org.uoc.pds.alpha.cultureindahouse.front;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.CategoryLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListCategoriesMB")
public class ListCategoriesMB {

	@EJB
	private CategoryLocal categoryLocal;

	public List<CategoryVO> getCategories() {
		return categoryLocal.list();
	}

	public String listCategories() {
		return "administration/listCategoryView.xhtml";
	}

	public String Administration() { return "administrationView.xhtml"; }

	public String errorAdministration() { return "administration/error.xhtml"; }
	public String errorEvent() { return "event/error.xhtml"; }
	public String errorMedia() { return "media/error.xhtml"; }
	public String errorProfile() { return "private/error.xhtml"; }

}
