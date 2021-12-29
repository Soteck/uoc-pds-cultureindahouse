package org.uoc.pds.alpha.cultureindahouse.front.Event;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.EventLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "EventMB")
public class EventMB {
    public String eventView() { return "eventView.xhtml"; }
    public String findEvent() { return "FindEventView.xhtml"; }
    public String findOrder() { return "FindOrdersView.xhtml"; }
}
