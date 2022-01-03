package org.uoc.pds.alpha.cultureindahouse.front.Event;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "EventMB")
public class EventMB {
    public String eventView() { return "eventView.xhtml"; }
    public String findEvent() { return "FindEventView.xhtml"; }
    public String findOrder() { return "FindOrdersView.xhtml"; }
}
