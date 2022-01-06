package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "SendCommentMB")
public class SendCommentMB {

    @EJB
    public MediaLocal mediaLocal;

    @Getter
    @Setter
    private Integer eventId;

    @Getter
    @Setter
    private String comment;

    public String SendComment(Integer userId)
    {
        mediaLocal.sendComment(eventId, userId, comment);
        return "FindOrdersView.xhtml";
    }
}
