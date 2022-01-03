package org.uoc.pds.alpha.cultureindahouse.front.label;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ShowLabelMB")
public class ShowLabelMB {

    @EJB
    private AdministrationLocal labelLocal;

    @Getter
    @Setter
    private Integer labelId = null;

    public LabelVO getLabel(){
        return labelLocal.showLabel(labelId);
    }

}
