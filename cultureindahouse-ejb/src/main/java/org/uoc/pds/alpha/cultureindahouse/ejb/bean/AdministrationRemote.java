package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AdministrationRemote {

    CategoryVO addCategory(String name, String description);

    CategoryVO updateCategory(int id, String name, String description);

    CategoryVO showCategory(int id);

    void deleteCategory(int id);

    List<CategoryVO> listAllCategories();

    EventOrganizerVO addEventOrganizer(String name, String description);

    EventOrganizerVO updateEventOrganizer(int id, String name, String description);

    EventOrganizerVO showEventOrganizer(int id);

    List<EventOrganizerVO> listAllEventOrganizers();

    void deleteEventOrganizer(int id);

    UserVO addAdministrator(String email, String password, String name, String surname, boolean isSuperAdministrator);

    UserVO updateAdministrator(int id, String email, String password, String name, String surname, boolean isSuperAdministrator);

    UserVO showAdministator(int id);

    EventOrganizerVO assignAdministratorToEventOrganizer(String email, int eventOrganizerId) throws Exception;

    EventOrganizerVO assignAdministratorToEventOrganizer(int userId, int eventOrganizerId) throws Exception;

    EventOrganizerVO unAssignAdministratorToEventOrganizer(int eventOrganizerId);

    List<UserVO> listAllAdministrators();

    void deleteAdministrator(int id);

    LabelVO addLabel(String name, String description);

    LabelVO updateLabel(int id, String name, String description);

    LabelVO showLabel(int id);

    List<LabelVO> listAllLabels();

    void deleteLabel(int id);

    void revokeAdministrator(int userId);
    void promoteAdministrator(int userId);
    void promoteSuperAdministrator(int userId);
    void revokeSuperAdministrator(int userId);

}
