package org.uoc.pds.alpha.cultureindahouse.front.category;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "AddCategoryMB")
public class AddCategoryMB {

    @EJB
    private AdministrationLocal categoryLocal;

    private CategoryVO category = new CategoryVO();

    public CategoryVO getCategory() {
        return category;
    }

    public void setCategory(CategoryVO category) {
        this.category = category;
    }

    public String anadirCategoria() {
        categoryLocal.addCategory(category.getName(), category.getDescription());
        category = new CategoryVO();
        return "listCategoryView.xhtml";
    }
}
