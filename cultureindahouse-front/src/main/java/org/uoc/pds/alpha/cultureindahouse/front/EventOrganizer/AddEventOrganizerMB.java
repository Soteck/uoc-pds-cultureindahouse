package org.uoc.pds.alpha.cultureindahouse.front.EventOrganizer;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "AddEventOrganizerMB")
public class AddEventOrganizerMB {

    @EJB
    private AdministrationLocal eventOrganizerLocal;

    private EventOrganizerVO eventOrganizer = new EventOrganizerVO();

    public EventOrganizerVO  getEventOrganizer() {
        return eventOrganizer;
    }

    public void setEventOrganizer(EventOrganizerVO  eventOrganizer) {
        this.eventOrganizer= eventOrganizer;
    }

    public String anadirEventOrganizer() {
        //TODO: ADD USERID
        //eventOrganizerLocal.addEventOrganizer(eventOrganizer.getName(), eventOrganizer.getDescription());
        eventOrganizer= new EventOrganizerVO();
        return "EventOrganizerListView.xhtml";
    }
}
