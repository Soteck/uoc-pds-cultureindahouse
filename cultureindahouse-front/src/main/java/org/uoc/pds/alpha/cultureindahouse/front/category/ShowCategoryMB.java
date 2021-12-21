package org.uoc.pds.alpha.cultureindahouse.front.category;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ShowCategoryMB")
public class ShowCategoryMB {

	@EJB
	private AdministrationLocal categoryLocal;

	protected Integer categoryId = null;

	public CategoryVO getCategory(){
		return categoryLocal.showCategory(categoryId);
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryName(int categoryId) {
		this.categoryId = categoryId;
	}
}
