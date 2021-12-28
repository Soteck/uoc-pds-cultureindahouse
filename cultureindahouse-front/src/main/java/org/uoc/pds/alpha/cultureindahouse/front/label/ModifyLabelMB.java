package org.uoc.pds.alpha.cultureindahouse.front.label;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ModifyLabelMB")
public class ModifyLabelMB {

    @EJB
    private AdministrationLocal labelLocal;

    @Getter
    @Setter
    protected Integer labelId = null;
    private LabelVO label;


    public LabelVO getLabel(){
        if(label == null || !(label.getId() == labelId)){
            label = labelLocal.showLabel(labelId);
        }
        return label;
    }

    public void setLabel(LabelVO label) {
        this.label = label;
    }

    public Object actualizarLabel() {
        labelLocal.updateLabel(labelId,label.getName(), label.getDescription());
        this.labelId = null;
        this.label = null;
        return "LabelListView.xhtml";
    }
}
