package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Response;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.ResponseVO;

import lombok.var;

public class ResponseMapper {


    public static Response toEntity(ResponseVO responseVO) {
        Response ret = new Response();

        ret.setId(responseVO.getId());
        ret.setMessage(responseVO.getMessage());



        var question = responseVO.getQuestion();
        if (question != null){
            ret.setQuestion(QuestionMapper.toEntity(question));
        }


        return ret;
    }

    public static ResponseVO toVO(Response response) {
        ResponseVO ret = new ResponseVO();
        ret.setId(response.getId());
        ret.setMessage(response.getMessage());

        var question = response.getQuestion();
        if (question != null){
            ret.setQuestion(QuestionMapper.toVO(question));
        }
        return ret;
    }

    public static List<Response> toEntity(List<ResponseVO> responses) {
        List<Response> ret = new ArrayList<>();
        for (ResponseVO Response : responses) {
            ret.add(toEntity(Response));
        }
        return ret;
    }

    public static List<ResponseVO> toVO(List<Response> responses) {
        List<ResponseVO> ret = new ArrayList<>();
        for (Response Response : responses) {
            ret.add(toVO(Response));
        }
        return ret;
    }


}
