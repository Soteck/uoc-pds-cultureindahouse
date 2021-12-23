package org.uoc.pds.alpha.cultureindahouse.front.label;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Console;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListLabelsMB")
public class ListLabelsMB {

    @EJB
    private AdministrationLocal labelLocal;

    public void deleteLabel(int labelId){ labelLocal.deleteLabel(labelId); }

    public List<LabelVO> getLabels() {
        return labelLocal.listAllLabels();
    }

    public String listLabels() {
        return "LabelListView.xhtml";
    }
    public String Administration() { return "administrationView.xhtml"; }
    public String errorLabel() { return "ErrorView.xhtml"; }
}
