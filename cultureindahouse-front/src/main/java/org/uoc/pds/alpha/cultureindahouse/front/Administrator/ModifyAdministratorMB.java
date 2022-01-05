package org.uoc.pds.alpha.cultureindahouse.front.Administrator;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ViewScoped
@ManagedBean(name = "ModifyAdministratorMB")
public class ModifyAdministratorMB {

	@EJB
	private AdministrationLocal administratorLocal;

    @Getter
    @Setter
	protected Integer userId = null;

    @Setter
	private UserVO user;


	@Getter
	@Setter
	private List<Integer> eventOrganizers = new ArrayList<>();

	private final List<Integer> originalEventOrganizers = new ArrayList<>();

	public UserVO getUser() {
		if (user == null || !(Objects.equals(user.getId(), userId))) {
			user = administratorLocal.showAdministator(userId);
			if (user.getEventOrganizers() != null) {
				for (EventOrganizerVO eventOrganizer : user.getEventOrganizers()) {
                    eventOrganizers.add(eventOrganizer.getId());
                    originalEventOrganizers.add(eventOrganizer.getId());
				}
			}
		}
		return user;
	}

	public Object updateAdministrator() throws Exception {
		administratorLocal.updateAdministrator(
				userId, user.getEmail(), user.getPassword(),
				user.getName(), user.getSurname(), user.isSuperAdministrator());


		if (user.getEventOrganizers() != null) {
			for (EventOrganizerVO eo : user.getEventOrganizers()) {
				if (!eventOrganizers.contains(eo.getId())) {
					administratorLocal.unAssignAdministratorToEventOrganizer(eo.getId());
				}
			}
		}

		for (Integer newEventOrganizer : eventOrganizers) {
			if (!originalEventOrganizers.contains(newEventOrganizer)) {
				administratorLocal.assignAdministratorToEventOrganizer(user.getId(), newEventOrganizer);
			}
		}

		this.userId = null;
		this.user = null;
		return "listAdministratorsView.xhtml";
	}

}
