package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.Remote;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Remote
public interface ProfileRemote {


	UserVO login(String email, String password);

	UserVO registerUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address);

	UserVO updateUser(String nif, String email, String password, String name, String surname, String preferedLanguage, String address);

	UserVO showUser(String email);

	UserVO showUser(int userId);

	void deleteUser(int userId);

	List<UserVO> listAllUsers();

	EventVO addEvent(String name, String description, String location, String image,
					 String initDate, String endDate, int eventOrganizerId, int categoryId);

	EventVO updateEvent(int eventId, String name, String description, String location, String image,
						String initDate, String endDate, int eventOrganizerId, int categoryId);
	EventVO showEvent(int id);

	EventVO showEventByName(String name);

	void addLabelToEvent(int eventId, int labelId);

	void removeLabelFromEvent(int eventId, int labelId);

}
