package org.uoc.pds.alpha.cultureindahouse.front.Event;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListEventsMB")
public class ListEventsMB {

	@EJB
	private ProfileLocal profileLocal;

	public List<EventVO> getEvents() {
		return profileLocal.listAllEvents();
	}


}
