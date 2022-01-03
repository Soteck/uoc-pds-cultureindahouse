package org.uoc.pds.alpha.cultureindahouse.front.label;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListLabelsMB")
public class ListLabelsMB {

    @EJB
    private AdministrationLocal labelLocal;

    public List<LabelVO> getLabels() {
        return labelLocal.listAllLabels();
    }


    public List<SelectItem> getFilterTypes() {
        List<SelectItem> filterTypes = new ArrayList<>();
        for (LabelVO label : getLabels()) {
            filterTypes.add(new SelectItem(label.getId(), label.getName()));

        }
        return filterTypes;
    }


    public String listLabels() {
        return "LabelListView.xhtml";
    }
    public String Administration() { return "administrationView.xhtml"; }
    public String errorLabel() { return "ErrorView.xhtml"; }

}
