package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Question;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;

import lombok.var;

public class QuestionMapper {


    public static Question toEntity(QuestionVO questionVO) {
        Question ret = new Question();

        ret.setId(questionVO.getId());
        ret.setMessage(questionVO.getMessage());
        ret.setTitle(questionVO.getTitle());

        var event = questionVO.getEvent();
        if (event != null){
            ret.setEvent(EventMapper.toEntity(event));
        }
        var response = questionVO.getResponse();
        if (response != null){
            ret.setResponse(ResponseMapper.toEntity(response));
        }

        return ret;
    }

    public static QuestionVO toVO(Question question) {
        QuestionVO ret = new QuestionVO();
        ret.setId(question.getId());
        ret.setMessage(question.getMessage());
        ret.setTitle(question.getTitle());

        var event = question.getEvent();
        if (event != null){
            ret.setEvent(EventMapper.toVO(event));
        }
        var response = question.getResponse();
        if (response != null){
            ret.setResponse(ResponseMapper.toVO(response));
        }
        return ret;
    }

    public static List<Question> toEntity(List<QuestionVO> categories) {
        List<Question> ret = new ArrayList<>();
        for (QuestionVO Question : categories) {
            ret.add(toEntity(Question));
        }
        return ret;
    }

    public static List<QuestionVO> toVO(List<Question> categories) {
        List<QuestionVO> ret = new ArrayList<>();
        for (Question Question : categories) {
            ret.add(toVO(Question));
        }
        return ret;
    }


}
