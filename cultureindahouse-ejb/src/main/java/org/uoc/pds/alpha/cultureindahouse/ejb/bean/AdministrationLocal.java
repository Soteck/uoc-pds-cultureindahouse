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

	EventOrganizerVO addEventOrganizer( String name, String description);

	EventOrganizerVO updateEventOrganizer (int id, String name, String description);

	EventOrganizerVO showEventOrganizer(int id);

	List<EventOrganizerVO> listAllEventOrganizers();

	UserVO addAdministrator (String email, String password, String name, String surname);

	UserVO updateAdministrator( String email, String password, String name, String surname);

	UserVO showAdministator ( String email);

	List<UserVO> listAllAdministrators();

	LabelVO addLabel (String name, String description);

	LabelVO updateLabel (int id, String name, String description);

	LabelVO showLabel(int id);

	List<LabelVO> listAllLabels();

	void removeLabel(int id);


}
