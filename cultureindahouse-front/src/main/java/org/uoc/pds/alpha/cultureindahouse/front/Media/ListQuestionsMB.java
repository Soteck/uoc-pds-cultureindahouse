package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListQuestionsMB")
public class ListQuestionsMB {

    @EJB
    private MediaLocal questionLocal;

    @Getter
    @Setter
    protected Integer eventId = null;

    public List<QuestionVO> getQuestions() {
        return questionLocal.listAllQuestions(eventId);
    }

    public boolean isQuestionAnswered(Integer questionId)
    {
        QuestionVO question = questionLocal.getQuestion(questionId);

        if(question.getResponse() != null) return true;

        return false;
    }

}


