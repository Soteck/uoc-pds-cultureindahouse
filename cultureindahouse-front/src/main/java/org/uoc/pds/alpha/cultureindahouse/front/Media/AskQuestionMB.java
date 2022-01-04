package org.uoc.pds.alpha.cultureindahouse.front.Media;


import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "AskQuestionMB")
public class AskQuestionMB {

    @EJB
    private MediaLocal questionLocal;

    @Getter
    @Setter
    protected Integer eventId = null;

    @Getter
    @Setter
    protected String title = null;

    @Getter
    @Setter
    protected String message = null;

    public void AskQuestion()
    {
        questionLocal.askQuestion(eventId,title,message);
    }


}
