package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
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


	@Getter @Setter
	private List<Integer> labels = new ArrayList<>();

	private final List<Integer> originalLabels = new ArrayList<>();

	public EventVO getEvent(){
		if(event == null || !(Objects.equals(event.getId(), eventId))){
			event = profileLocal.showEvent(eventId);
			eventOrganizer = event.getEventOrganizer().getId().toString();
			category = event.getCategory().getId().toString();
			if(event.getLabels() != null){
				for(LabelVO label : event.getLabels()){
					labels.add(label.getId());
					originalLabels.add(label.getId());
				}
			}

		}
		return event;
	}

	public Object updateEvent() {

		profileLocal.updateEvent(
				eventId, event.getName(), event.getDescription(), event.getLocation(),
				event.getImage(), event.getInitDate(), event.getEndDate(),
				Integer.parseInt(eventOrganizer), Integer.parseInt(category));

		if(event.getLabels() != null){
			for(LabelVO label : event.getLabels()){
				if(!labels.contains(label.getId())){
					profileLocal.removeLabelFromEvent(event.getId(), label.getId());
				}
			}
		}

		for(Integer newLabel : labels){
			if(!originalLabels.contains(newLabel)){
				profileLocal.addLabelToEvent(event.getId(), newLabel);
			}
		}

		this.eventId = null;
		this.event = null;
		this.eventOrganizer = null;
		this.category = null;
		return "listEventView.xhtml";
	}


}
