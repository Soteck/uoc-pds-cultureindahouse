package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Objects;

@ViewScoped
@ManagedBean(name = "EditEventMB")
public class EditEventMB {

	@EJB
	private ProfileLocal profileLocal;

	@Setter
	private EventVO event;

	@Getter
	@Setter
	protected Integer eventId = null;

	@Getter
	@Setter
	private String eventOrganizer = null;

	@Getter
	@Setter
	private String category = null;


	public EventVO getEvent(){
		if(event == null || !(Objects.equals(event.getId(), eventId))){
			event = profileLocal.showEvent(eventId);
			eventOrganizer = event.getEventOrganizer().getId().toString();
			category = event.getCategory().getId().toString();
		}
		return event;
	}

	public Object updateEvent() {
		profileLocal.updateEvent(
				eventId, event.getName(), event.getDescription(), event.getLocation(),
				event.getImage(), event.getInitDate(), event.getEndDate(),
				Integer.parseInt(eventOrganizer), Integer.parseInt(category));
		this.eventId = null;
		this.event = null;
		this.eventOrganizer = null;
		this.category = null;
		return "listEventView.xhtml";
	}


}
