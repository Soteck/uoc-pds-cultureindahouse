package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface MediaRemote {

    CommentVO sendComment(int eventId, String email, String text);

    CommentVO sendComment(int eventId, int userId, String text);

    RatingVO addRating(int eventId, String email, int rating);

    RatingVO addRating(int eventId, int userId, int rating);

    UserVO addToFavorites(int eventId, String email);

    UserVO addToFavorites(int eventId, int userId);

    List<EventVO> listAllFavorites();

    List<EventVO> listAllFavorites(String email);

    List<EventVO> listAllFavorites(int userId);

    QuestionVO getQuestion(int questionId);

    ResponseVO getResponse(int questionId);

    List<QuestionVO> listAllQuestions(int eventId);

    ResponseVO answerQuestion(int questionId, String message);

    QuestionVO askQuestion(int eventId, String title, String message);

}
