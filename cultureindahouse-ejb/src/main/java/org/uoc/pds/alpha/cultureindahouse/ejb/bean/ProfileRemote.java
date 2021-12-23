package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.Remote;
import java.util.Date;

@Remote
public interface ProfileRemote {


	UserVO login(String email, String password);

	UserVO registerUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address);

	UserVO updateUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address);

	UserVO showUser(String email);

	EventVO addEvent(String name, String description, String location, String image, Date initDate, Date endDate, int eventOrganizerId);

	EventVO updateEvent(int eventId, String name, String description, String location, String image, Date initDate, Date endDate, int eventOrganizerId);

	EventVO showEvent(String name);

	void addCategoryToEvent(int eventId, int categoryId);

	void removeCategoryFromEvent(int eventId);

	void addLabelToEvent(int eventId, int labelId);

	void removeLabelFromEvent(int eventId, int labelId);

}
