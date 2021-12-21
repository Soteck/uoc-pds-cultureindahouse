package org.uoc.pds.alpha.cultureindahouse.front.category;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "EditCategoryMB")
public class EditCategoryMB {

	@EJB
	private AdministrationLocal categoryLocal;

	protected Integer categoryId = null;
	private CategoryVO category;

	public CategoryVO getCategory(){
		if(category == null || !(category.getId() == categoryId)){
			category = categoryLocal.showCategory(categoryId);
		}
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId =  categoryId;
	}

    public Object actualizarCategoria() {
		categoryLocal.updateCategory(categoryId,category.getName(), category.getDescription());
		this.categoryId = null;
		this.category = null;
		return "listCategoryView.xhtml";
    }
}
