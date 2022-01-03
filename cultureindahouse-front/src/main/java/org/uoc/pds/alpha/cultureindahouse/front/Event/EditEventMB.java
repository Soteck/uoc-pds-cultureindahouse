package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
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

	@Getter
	@Setter
	protected Integer eventId = null;
	private EventVO event;

	public EventVO getCategory() {
		if (event == null || !(Objects.equals(event.getId(), eventId))) {
			event = profileLocal.showEvent(eventId);
		}
		return event;
	}

	public void setEvent(EventVO event) {
		this.event = event;
	}

	public Object updateEvent() {
		profileLocal.updateEvent(
				eventId, event.getName(), event.getDescription(), event.getLocation(),
				event.getImage(), event.getInitDate(), event.getEndDate(), event.getEventOrganizer().getId());
		this.eventId = null;
		this.event = null;
		return "listEventsView.xhtml";
	}
}
