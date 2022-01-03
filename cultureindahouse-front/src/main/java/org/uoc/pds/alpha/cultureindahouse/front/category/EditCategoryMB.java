package org.uoc.pds.alpha.cultureindahouse.front.category;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Objects;

@ViewScoped
@ManagedBean(name = "EditCategoryMB")
public class EditCategoryMB {

	@EJB
	private AdministrationLocal categoryLocal;

	@Getter
	@Setter
	protected Integer categoryId = null;
	private CategoryVO category;

	public CategoryVO getCategory(){
		if(category == null || !(Objects.equals(category.getId(), categoryId))){
			category = categoryLocal.showCategory(categoryId);
		}
		return category;
	}

	public void setCategory(CategoryVO category) {
		this.category = category;
	}

	public Object actualizarCategoria() {
		categoryLocal.updateCategory(categoryId,category.getName(), category.getDescription());
		this.categoryId = null;
		this.category = null;
		return "listCategoryView.xhtml";
    }
}
