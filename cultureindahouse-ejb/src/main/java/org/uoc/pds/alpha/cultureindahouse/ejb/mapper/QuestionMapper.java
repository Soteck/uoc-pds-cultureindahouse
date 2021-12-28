package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Question;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;

import lombok.var;

public class QuestionMapper {


    public static Question toEntity(QuestionVO questionVO, boolean relations) {
        Question ret = new Question();

        ret.setId(questionVO.getId());
        ret.setMessage(questionVO.getMessage());
        ret.setTitle(questionVO.getTitle());

        var event = questionVO.getEvent();
        if (relations && event != null){
            ret.setEvent(EventMapper.toEntity(event, false));
        }
        var response = questionVO.getResponse();
        if (relations && response != null){
            ret.setResponse(ResponseMapper.toEntity(response, false));
        }

        return ret;
    }

    public static QuestionVO toVO(Question question, boolean relations) {
        QuestionVO ret = new QuestionVO();
        ret.setId(question.getId());
        ret.setMessage(question.getMessage());
        ret.setTitle(question.getTitle());

        var event = question.getEvent();
        if (relations && event != null){
            ret.setEvent(EventMapper.toVO(event, false));
        }
        var response = question.getResponse();
        if (relations && response != null){
            ret.setResponse(ResponseMapper.toVO(response, false));
        }
        return ret;
    }

    public static List<Question> toEntity(Collection<QuestionVO> categories, boolean relations) {
        List<Question> ret = new ArrayList<>();
        for (QuestionVO Question : categories) {
            ret.add(toEntity(Question, relations));
        }
        return ret;
    }

    public static List<QuestionVO> toVO(Collection<Question> categories, boolean relations) {
        List<QuestionVO> ret = new ArrayList<>();
        for (Question Question : categories) {
            ret.add(toVO(Question, relations));
        }
        return ret;
    }


}
