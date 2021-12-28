package org.uoc.pds.alpha.cultureindahouse.front.label;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "RemoveLabelMB")

public class RemoveLabelMB {

    @EJB
    private AdministrationLocal labelLocal;

    @Getter
    @Setter
    private Integer labelId = null;

    public String deleteLabel(){
        labelLocal.deleteLabel(labelId);
        return "labelListView.xhtml";
    }

}
