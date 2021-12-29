package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.EventLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "ShowEventMB")
public class ShowEventMB {

    @EJB
    private EventLocal eventLocal;

    @Getter
    @Setter
    private Integer eventId = null;

    public EventVO getEvent(){
        return eventLocal.showEvent(eventId);
    }

}
