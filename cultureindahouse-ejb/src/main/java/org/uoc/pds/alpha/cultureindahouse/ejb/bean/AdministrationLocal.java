package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdministrationLocal {

	CategoryVO addCategory(String name, String description);

	CategoryVO updateCategory(int id, String name, String description);

	CategoryVO showCategory(int id);

	List<CategoryVO> listAllCategories();

	void deleteCategory(int id);

	EventOrganizerVO addEventOrganizer(String name, String description);

	EventOrganizerVO updateEventOrganizer(int id, String name, String description);

	EventOrganizerVO showEventOrganizer(int id);

	List<EventOrganizerVO> listAllEventOrganizers();

	void deleteEventOrganizer(int id);

	UserVO addUser(String email, String password, String name, String surname);

	UserVO updateUser(int id, String email, String password, String name, String surname);

	UserVO showUser(int id);

	List<UserVO> listAllUsers();

	void deleteUser(int id);

	LabelVO addLabel(String name, String description);

	LabelVO updateLabel(int id, String name, String description);

	LabelVO showLabel(int id);

	List<LabelVO> listAllLabels();

	void deleteLabel(int id);


}
