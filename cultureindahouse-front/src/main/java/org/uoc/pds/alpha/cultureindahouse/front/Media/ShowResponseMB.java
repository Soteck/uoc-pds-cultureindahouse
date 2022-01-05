package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.ResponseVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ShowResponseMB")
public class ShowResponseMB {

    @EJB
    private MediaLocal questionLocal;

    @Getter
    @Setter
    private Integer questionId = null;

    public ResponseVO getResponse(){
        return questionLocal.getResponse(questionId);
    }

    public String showMedia() { return "MediaView.xhtml";}
}
