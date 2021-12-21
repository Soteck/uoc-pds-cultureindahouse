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

}
