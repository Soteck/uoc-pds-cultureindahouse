package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "AnswerQuestionMB")
public class AnswerQuestionMB {

    @EJB
    private MediaLocal questionLocal;

    @Getter
    @Setter
    protected Integer questionId = null;

    @Getter
    @Setter
    protected String message = null;

    public QuestionVO getQuestion(){
        return questionLocal.getQuestion(questionId);
    }

    public String AnswerQuestion()
    {
        questionLocal.answerQuestion(questionId,message);
        return "FindEventView.xhtml";
    }
}
