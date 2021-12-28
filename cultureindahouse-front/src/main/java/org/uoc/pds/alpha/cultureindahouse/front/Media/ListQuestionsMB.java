package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Console;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListQuestionsMB")
public class ListQuestionsMB {

    @EJB
    private MediaLocal questionLocal;

    @Getter
    @Setter
    protected Integer eventId = null;
    private QuestionVO question;

    public List<QuestionVO> getQuestions() {
        return questionLocal.listAllQuestions(eventId);
    }

}


