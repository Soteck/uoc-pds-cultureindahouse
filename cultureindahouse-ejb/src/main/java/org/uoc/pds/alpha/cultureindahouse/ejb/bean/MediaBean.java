package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collection;
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
	public CommentVO sendComment(int eventId, String email, String text) {

		Event event = eventRepository.get(eventId);
		User user = userRepository.getUserByEmail(email);

		Comment comment = new Comment(text, event, user);
		Comment ret = commentRepository.add(comment);

		return CommentMapper.toVO(ret, true);
	}

	@Override
	public CommentVO sendComment(int eventId, int userId, String text) {

		Event event = eventRepository.get(eventId);
		User user = userRepository.get(userId);

		Comment comment = new Comment(text, event, user);
		Comment ret = commentRepository.add(comment);

		return CommentMapper.toVO(ret, true);
	}

	@Override
	public RatingVO addRating(int eventId, String email, int rating) {
		Event event = eventRepository.get(eventId);
		User user = userRepository.getUserByEmail(email);

		Rating ret = new Rating(rating, event, user);

		return RatingMapper.toVO(ratingRepository.add(ret), true);

	}

	@Override
	public RatingVO addRating(int eventId, int userId, int rating) {
		Event event = eventRepository.get(eventId);
		User user = userRepository.get(userId);

		Rating ret = new Rating(rating, event, user);

		return RatingMapper.toVO(ratingRepository.add(ret), true);

	}

	@Override
	public UserVO addToFavorites(int eventId, String email) {
		Event event = eventRepository.get(eventId);
		User user = userRepository.getUserByEmail(email);

		Collection<Event> favorites = user.getFavorites();

		if (favorites == null) {
			favorites = new ArrayList<Event>();
		}

		favorites.add(event);

		user.setFavorites(favorites);

		return UserMapper.toVO(userRepository.update(user.getId(), user), true);

	}

	@Override
	public UserVO addToFavorites(int eventId, int userId) {
        Event event = eventRepository.get(eventId);
        User user = userRepository.get(userId);

        Collection<Event> favorites = user.getFavorites();

		if (favorites == null) {
			favorites = new ArrayList<Event>();
		}

		favorites.add(event);

		user.setFavorites(favorites);

		return UserMapper.toVO(userRepository.update(user.getId(), user), true);

	}

	@Override
	public List<EventVO> listAllFavorites() {

        List<User> users = userRepository.list();

        ArrayList<Event> events = new ArrayList<Event>();
		for (User u : users) {
			Collection<Event> favorites = u.getFavorites();
			if (favorites != null && !favorites.isEmpty()) {
				events.addAll(u.getFavorites());
			}

		}

		return EventMapper.toVO(events, true);
	}

	@Override
	public List<EventVO> listAllFavorites(String email) {

        User user = userRepository.getUserByEmail(email);

        ArrayList<Event> events = new ArrayList<Event>();

        Collection<Event> favorites = user.getFavorites();
		if (user.getFavorites() != null && !favorites.isEmpty()) {
			events = new ArrayList<Event>(favorites);
		}

		return EventMapper.toVO(events, true);

	}

	@Override
	public List<EventVO> listAllFavorites(int userId) {

        User user = userRepository.get(userId);

        ArrayList<Event> events = new ArrayList<Event>();

		Collection<Event> favorites = user.getFavorites();
		if (user.getFavorites() != null && !favorites.isEmpty()) {
			events = new ArrayList<Event>(favorites);
		}

		return EventMapper.toVO(events, true);

	}


	@Override
	public QuestionVO getQuestion(int questionId) {

		return QuestionMapper.toVO(questionRepository.get(questionId), true);
	}

	@Override
	public ResponseVO getResponse(int questionId) {

        Question question = questionRepository.get(questionId);

        Response response = question.getResponse();
        ResponseVO ret = new ResponseVO();

		if (response != null) {
			ret = ResponseMapper.toVO(response, true);
		}

		return ret;

	}

	@Override
	public List<QuestionVO> listAllQuestions(int eventId) {

        Event event = eventRepository.get(eventId);

        ArrayList<Question> ret = new ArrayList<Question>();

        Collection<Question> questions = event.getQuestions();

		if (questions != null && !questions.isEmpty()) {
			ret = new ArrayList<>(questions);
		}

		return QuestionMapper.toVO(ret, true);

	}

	@Override
	public ResponseVO answerQuestion(int questionId, String message) {

        Question question = questionRepository.get(questionId);
        Response response = new Response(message, question);

		return ResponseMapper.toVO(responseRepository.add(response), true);

	}

	@Override
	public QuestionVO askQuestion(int eventId, String title, String message) {

        Event event = eventRepository.get(eventId);

        Question question = new Question(title, message, event);

		return QuestionMapper.toVO(questionRepository.add(question), true);
	}


}
