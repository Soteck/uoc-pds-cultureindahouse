package org.uoc.pds.alpha.cultureindahouse.front.label;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ViewScoped
@ManagedBean(name = "RemoveLabelMB")

public class RemoveLabelMB {

    @EJB
    private AdministrationLocal labelLocal;

    @Getter
    @Setter
    private Integer labelId = null;

    public String deleteLabel(){
        labelLocal.deleteLabel(labelId);
        this.labelId = null;
        return "administrationView.xhtml";
    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }


}
