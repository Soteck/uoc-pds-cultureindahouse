package org.uoc.pds.alpha.cultureindahouse.front.category;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ShowCategoryMB")
public class ShowCategoryMB {

	@EJB
	private AdministrationLocal categoryLocal;

	@Getter
	@Setter
	private Integer categoryId = null;

	public CategoryVO getCategory(){
		return categoryLocal.showCategory(categoryId);
	}

}
