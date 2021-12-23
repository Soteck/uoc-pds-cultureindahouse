package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import lombok.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
public class EventVO {


	private Integer id;

	private String name;

	private String description;

	private String location;

	private String image;

	private Date initDate;

	private Date endDate;

	private EventOrganizerVO eventOrganizer;

	private UserVO user;

	private CategoryVO category;

	private List<OrderHistoryVO> orderHistory;

	private List<LabelVO> labels;

	private List<RatingVO> ratings;

	private List<CommentVO> comments;

	private List<QuestionVO> questions;

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
