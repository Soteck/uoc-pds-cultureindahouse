package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;

@Local
public interface ProfileLocal {

	UserVO login(String email, String password);

	UserVO registerUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address);

	UserVO updateUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address);

	UserVO showUser(String email);

	UserVO showUser(int userId);

	void deleteUser(int userId);

	List<UserVO> listAllUsers();

	EventVO addEvent(String name, String description, String location, String image, Date initDate, Date endDate, int eventOrganizerId);

	EventVO updateEvent(int eventId, String name, String description, String location, String image, Date initDate, Date endDate, int eventOrganizerId);

	EventVO showEvent(String name);


	void addCategoryToEvent(int eventId, int categoryId);

	void removeCategoryFromEvent(int eventId);

	void addLabelToEvent(int eventId, int labelId);

	void removeLabelFromEvent(int eventId, int labelId);
}
