package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "AddEventMB")
public class AddEventMB {

    @EJB
    private ProfileLocal profileLocal;;

    @Getter
    @Setter
    private EventVO event = new EventVO();

    @Getter
    @Setter
    private String eventOrganizer = null;

    @Getter @Setter
    private String category = null;

    public String addEvent() {
        profileLocal.addEvent(event.getName(), event.getDescription(), event.getLocation(),
                event.getImage(), event.getInitDate(), event.getEndDate(),
                Integer.parseInt(eventOrganizer), Integer.parseInt(category));
        this.event = new EventVO();
        this.eventOrganizer = null;
        this.category = null;
        return "listEventView.xhtml";
    }
}
