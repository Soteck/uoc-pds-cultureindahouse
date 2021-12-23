package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Comment;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CommentVO;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {


    public static Comment toEntity(CommentVO commentVO) {
        Comment ret = new Comment();
        ret.setId(commentVO.getId());
        ret.setText(commentVO.getText());
        var event = commentVO.getEvent();

        if (event != null) {
            ret.setEvent(EventMapper.toEntity(event));
        }
        var user = commentVO.getUser();

        if (user != null) {
            ret.setUser(UserMapper.toEntity(user));
        }
        return ret;
    }

    public static CommentVO toVO(Comment comment) {
        CommentVO ret = new CommentVO();
        ret.setId(comment.getId());
        ret.setText(comment.getText());

        var event = comment.getEvent();

        if (event != null) {
            ret.setEvent(EventMapper.toVO(event));
        }
        var user = comment.getUser();

        if (user != null) {
            ret.setUser(UserMapper.toVO(user));
        }
        return ret;
    }


    public static List<Comment> toEntity(List<CommentVO> comments) {
        List<Comment> ret = new ArrayList<>();
        for (CommentVO comment : comments) {
            ret.add(toEntity(comment));
        }
        return ret;
    }

    public static List<CommentVO> toVO(List<Comment> comments) {
        List<CommentVO> ret = new ArrayList<>();
        for (Comment comment : comments) {
            ret.add(toVO(comment));
        }
        return ret;
    }


}
