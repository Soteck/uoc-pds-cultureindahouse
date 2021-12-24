package org.uoc.pds.alpha.cultureindahouse.front.EventOrganizer;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ModifyEventOrganizerMB")
public class ModifyEventOrganizerMB {

    @EJB
    private AdministrationLocal eventOrganizerLocal;

    @Getter
    @Setter
    protected Integer eventOrganizerId = null;
    private EventOrganizerVO eventOrganizer;

    public EventOrganizerVO getEventOrganizer(){
        if(eventOrganizer == null || !(eventOrganizer.getId() == eventOrganizerId)){
            eventOrganizer= eventOrganizerLocal.showEventOrganizer(eventOrganizerId);
        }
        return eventOrganizer;
    }

    public void setEventOrganizer(EventOrganizerVO eventOrganizer) {
        this.eventOrganizer = eventOrganizer;
    }

    public Object actualizarEventOrganizer() {
        eventOrganizerLocal.updateEventOrganizer(eventOrganizerId,eventOrganizer.getName(), eventOrganizer.getDescription());
        this.eventOrganizerId = null;
        this.eventOrganizer = null;
        return "EventOrganizerListView.xhtml";
    }
}
