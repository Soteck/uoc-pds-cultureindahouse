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
@ManagedBean(name = "ShowEventOrganizerMB")
public class ShowEventOrganizerMB {

    @EJB
    private AdministrationLocal eventOrganizerLocal;

    @Getter
    @Setter
    private Integer eventOrganizerId = null;

    public EventOrganizerVO getEventOrganizer(){
        return eventOrganizerLocal.showEventOrganizer(eventOrganizerId);
    }
}
