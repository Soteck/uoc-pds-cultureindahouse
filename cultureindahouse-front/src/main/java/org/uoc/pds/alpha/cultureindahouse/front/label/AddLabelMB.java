package org.uoc.pds.alpha.cultureindahouse.front.label;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "AddLabelMB")

public class AddLabelMB {

    @EJB
    private AdministrationLocal labelLocal;

    private LabelVO label = new LabelVO();

    public LabelVO getLabel() {
        return label;
    }

    public void setLabel(LabelVO label) {
        this.label = label;
    }

    public String anadirLabel() {
        labelLocal.addLabel(label.getName(), label.getDescription());
        label= new LabelVO();
        return "LabelListView.xhtml";
    }

}
