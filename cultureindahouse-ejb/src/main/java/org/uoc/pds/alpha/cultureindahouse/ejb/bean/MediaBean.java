package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Stateless
public class MediaBean implements MediaLocal, MediaRemote {

    @EJB
    private QuestionRepositoryInterface questionRepository;

    @EJB
    private ResponseRepositoryInterface responseRepository;

    @EJB
    private EventRepositoryInterface eventRepository;

    @EJB
    private UserRepositoryInterface userRepository;

	@EJB
	private CommentRepositoryInterface commentRepository;

	@EJB
	private RatingRepositoryInterface ratingRepository;


    @Override
    public CommentVO sendComment(int eventId, String email, String text){

        var event = eventRepository.get(eventId);
        var user = userRepository.getUserByEmail(email);

        var comment = new Comment(text,event,user);
        var ret = commentRepository.add(comment);

        return CommentMapper.toVO(ret);
    }

    @Override
    public CommentVO sendComment(int eventId, int userId, String text){

        var event = eventRepository.get(eventId);
        var user = userRepository.get(userId);

        var comment = new Comment(text,event,user);
        var ret = commentRepository.add(comment);

        return CommentMapper.toVO(ret);
    }

    @Override
    public RatingVO addRating(int eventId, String email, int rating){
        var event = eventRepository.get(eventId);
        var user = userRepository.getUserByEmail(email);

        var ret = new Rating(rating, event, user);

        return RatingMapper.toVO(ratingRepository.add(ret));

    }

    @Override
    public RatingVO addRating(int eventId, int userId, int rating){
        var event = eventRepository.get(eventId);
        var user = userRepository.get(userId);

        var ret = new Rating(rating, event, user);

        return RatingMapper.toVO(ratingRepository.add(ret));

    }

    @Override
    public UserVO addToFavorites(int eventId, String email){
        var event = eventRepository.get(eventId);
        var user = userRepository.getUserByEmail(email);

        var favorites = user.getFavorites();

        if (favorites == null){
            favorites = new ArrayList<Event>();
        }

        favorites.add(event);

        return UserMapper.toVO(userRepository.update(user.getId(),user));

    }

    @Override
    public UserVO addToFavorites(int eventId, int userId){
        var event = eventRepository.get(eventId);
        var user = userRepository.get(userId);

        var favorites = user.getFavorites();

        if (favorites == null){
            favorites = new ArrayList<Event>();
        }

        favorites.add(event);

        return UserMapper.toVO(userRepository.update(user.getId(),user));

    }
    @Override
    public List<EventVO> listAllFavorites(){

        var users = userRepository.list();

        var events = new ArrayList<Event>();
        for (User u :users) {
            var favorites = u.getFavorites();
            if (favorites != null && !favorites.isEmpty()){
                events.addAll(u.getFavorites());
            }

        }

        return EventMapper.toVO(events);
    }

    @Override
    public List<EventVO> listAllFavorites(String email){

        var user = userRepository.getUserByEmail(email);

        var events = new ArrayList<Event>();

        var favorites = user.getFavorites();
        if (user.getFavorites() !=  null && !favorites.isEmpty()){
            events = new ArrayList<Event>(favorites);
        }

        return EventMapper.toVO(events);

    }

    @Override
    public List<EventVO> listAllFavorites(int userId){

        var user = userRepository.get(userId);

        var events = new ArrayList<Event>();

        var favorites = user.getFavorites();
        if (user.getFavorites() !=  null && !favorites.isEmpty()){
            events = new ArrayList<Event>(favorites);
        }

        return EventMapper.toVO(events);

    }


    @Override
    public QuestionVO getQuestion(int questionId){

        return QuestionMapper.toVO(questionRepository.get(questionId));
    }

    @Override
    public ResponseVO getResponse(int questionId){

        var question = questionRepository.get(questionId);

        var response = question.getResponse();
        var ret = new ResponseVO();

        if (response != null){
            ret = ResponseMapper.toVO(response);
        }

        return ret;

    }

    @Override
    public List<QuestionVO> listAllQuestions(int eventId){

        var event = eventRepository.get(eventId);

        var ret = new ArrayList<Question>();

        var questions = event.getQuestions();

        if (questions != null && !questions.isEmpty()){
            ret = new ArrayList<>(questions);
        }

        return QuestionMapper.toVO(ret);

    }

    @Override
    public ResponseVO answerQuestion(int questionId, String message){

        var question = questionRepository.get(questionId);
        var response = new Response(message,question );

        return ResponseMapper.toVO(responseRepository.add(response));

    }

    @Override
    public QuestionVO askQuestion(int eventId, String title, String message){

        var event = eventRepository.get(eventId);

        var question = new Question(title,message,event);

        return QuestionMapper.toVO(questionRepository.add(question));
    }


}
