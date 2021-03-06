package org.uoc.pds.alpha.cultureindahouse.front.label;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
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
        labelLocal.addLabel(this.label.getName(), this.label.getDescription());
        label= new LabelVO();
        return "LabelListView.xhtml";
    }

}
