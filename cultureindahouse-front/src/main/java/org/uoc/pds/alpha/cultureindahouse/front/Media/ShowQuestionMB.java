package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ShowQuestionMB")
public class ShowQuestionMB {

    @EJB
    private MediaLocal questionLocal;

    @Getter
    @Setter
    private Integer questionId = null;

    public QuestionVO getQuestion(){
        return questionLocal.getQuestion(questionId);
    }

    public String showMedia() { return "MediaView.xhtml";}

}

