package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Comment;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CommentVO;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {


    public static Comment toEntity(CommentVO commentVO, boolean relations) {
        Comment ret = new Comment();
        ret.setId(commentVO.getId());
        ret.setText(commentVO.getText());
        var event = commentVO.getEvent();

        if (relations && event != null) {
            ret.setEvent(EventMapper.toEntity(event, false));
        }
        var user = commentVO.getUser();

        if (relations && user != null) {
            ret.setUser(UserMapper.toEntity(user, false));
        }
        return ret;
    }

    public static CommentVO toVO(Comment comment, boolean relations) {
        CommentVO ret = new CommentVO();
        ret.setId(comment.getId());
        ret.setText(comment.getText());

        var event = comment.getEvent();

        if (relations && event != null) {
            ret.setEvent(EventMapper.toVO(event, false));
        }
        var user = comment.getUser();

        if (relations && user != null) {
            ret.setUser(UserMapper.toVO(user, false));
        }
        return ret;
    }


    public static List<Comment> toEntity(List<CommentVO> comments, boolean relations) {
        List<Comment> ret = new ArrayList<>();
        for (CommentVO comment : comments) {
            ret.add(toEntity(comment, relations));
        }
        return ret;
    }

    public static List<CommentVO> toVO(List<Comment> comments, boolean relations) {
        List<CommentVO> ret = new ArrayList<>();
        for (Comment comment : comments) {
            ret.add(toVO(comment, relations));
        }
        return ret;
    }


}
