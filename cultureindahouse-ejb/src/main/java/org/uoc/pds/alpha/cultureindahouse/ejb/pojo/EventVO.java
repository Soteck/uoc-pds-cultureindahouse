package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.helpers.DateHelper;

import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
public class EventVO {


	private Integer id;

	private String name;

	private String description;

	private String location;

	private String image;

	private String initDate;

	private String endDate;

	private EventOrganizerVO eventOrganizer;

	private CategoryVO category;

	private Collection<UserVO> userFavorites;

	private Collection<OrderHistoryVO> orderHistory;

	private Collection<LabelVO> labels;

	private Collection<RatingVO> ratings;

	private Collection<CommentVO> comments;

	private Collection<QuestionVO> questions;


	public EventVO(String name, String description, String location, String image, LocalDate initDate, LocalDate endDate) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.image = image;
		this.initDate = DateHelper.toString(initDate) ;
		this.endDate = DateHelper.toString(endDate) ;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EventVO event = (EventVO) o;
		return Objects.equals(id, event.id) && Objects.equals(name, event.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
