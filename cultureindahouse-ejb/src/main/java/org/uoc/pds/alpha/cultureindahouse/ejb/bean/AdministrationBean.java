package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.EventOrganizer;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.CategoryMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.EventOrganizerMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.LabelMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.UserMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.CategoryRepositoryInterface;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.EventOrganizerRepositoryInterface;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.LabelRepositoryInterface;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.UserRepositoryInterface;

import lombok.var;

@Stateless
public class AdministrationBean implements AdministrationLocal, AdministrationRemote {

    @EJB
    private CategoryRepositoryInterface categoryRepository;
    @EJB
    private EventOrganizerRepositoryInterface eventOrganizerRepository;
    @EJB
    private UserRepositoryInterface userRepository;
    @EJB
    private LabelRepositoryInterface labelRepository;


    @Override
    public CategoryVO addCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return CategoryMapper.toVO(categoryRepository.add(category), true);
    }

    @Override
    public CategoryVO updateCategory(int id, String name, String description) {
        Category data = new Category();
        data.setName(name);
        data.setDescription(description);
        return CategoryMapper.toVO(this.categoryRepository.update(id, data), true);
    }

    @Override
    public CategoryVO showCategory(int id) {
        return CategoryMapper.toVO(this.categoryRepository.get(id), true);
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryRepository.delete(id);
    }

    @Override
    public List<CategoryVO> listAllCategories() {
        List<Category> data = categoryRepository.list();
        return CategoryMapper.toVO(data, true);
    }

    @Override
    public EventOrganizerVO addEventOrganizer(String name, String description, int userId) throws Exception {
        EventOrganizer eventOrganizer = new EventOrganizer();
        var user = userRepository.get(userId);

        if (!user.isAdministrator()){
            throw new Exception("User must be an admistrator.");
        }
        eventOrganizer.setName(name);
        eventOrganizer.setDescription(description);

        eventOrganizer.setAdministrator(user);
        return EventOrganizerMapper.toVO(eventOrganizerRepository.add(eventOrganizer), true);
    }

    @Override
    public EventOrganizerVO updateEventOrganizer(int id, String name, String description, Integer userId) throws Exception {
        EventOrganizer eventOrganizer = eventOrganizerRepository.get(id);

        if (userId != null){
            var user = userRepository.get(userId);

            if (!user.isAdministrator()){
                throw new Exception("User must be an admistrator.");
            }

            eventOrganizer.setAdministrator(user);
        }

        if (name != null){
            eventOrganizer.setName(name);
        }

        if (description != null){
            eventOrganizer.setDescription(description);
        }


        return EventOrganizerMapper.toVO(eventOrganizerRepository.update(id, eventOrganizer), true);
    }

    @Override
    public EventOrganizerVO showEventOrganizer(int id) {
        return EventOrganizerMapper.toVO(eventOrganizerRepository.get(id), true);
    }

    @Override
    public List<EventOrganizerVO> listAllEventOrganizers() {
        List<EventOrganizer> data = eventOrganizerRepository.list();
        return EventOrganizerMapper.toVO(data, true);
    }

    @Override
    public void deleteEventOrganizer(int id) {
        this.eventOrganizerRepository.delete(id);
    }

    @Override
    public UserVO addAdministrator(String email, String password, String name, String surname) {

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setSurname(surname);
        user.setAdministrator(true);
        return UserMapper.toVO(userRepository.add(user), true);

    }

    @Override
    public UserVO updateAdministrator(int id, String email, String password, String name, String surname) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setSurname(surname);
        user.setAdministrator(true);
        return UserMapper.toVO(userRepository.update(id, user), true);
    }

    @Override
    public UserVO showAdministator(int id) {

        return UserMapper.toVO(userRepository.get(id), true);
    }

    @Override
    public List<UserVO> listAllAdministrators() {

        List<User> data = userRepository.list();
        var users = UserMapper.toVO(data, true);

        return users.stream().filter(UserVO::isAdministrator).collect(Collectors.toList());

    }

    @Override
    public void deleteAdministrator(int id) {
        this.userRepository.delete(id);
    }

    @Override
    public LabelVO addLabel(String name, String description) {
        Label label = new Label();
        label.setName(name);
        label.setDescription(description);
        return LabelMapper.toVO(labelRepository.add(label), true);
    }

    @Override
    public LabelVO updateLabel(int id, String name, String description) {

        Label label = new Label();
        label.setName(name);
        label.setDescription(description);
        return LabelMapper.toVO(labelRepository.update(id, label), true);
    }

    @Override
    public LabelVO showLabel(int id) {
        return LabelMapper.toVO(labelRepository.get(id), true);
    }

    @Override
    public List<LabelVO> listAllLabels() {
        List<Label> data = labelRepository.list();
        return LabelMapper.toVO(data, true);
    }

    @Override
    public void deleteLabel(int id) {
        this.labelRepository.delete(id);
    }


}
