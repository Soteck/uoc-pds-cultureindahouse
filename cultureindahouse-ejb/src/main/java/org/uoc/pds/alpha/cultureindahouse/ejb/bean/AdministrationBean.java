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
        return CategoryMapper.entityToVO(categoryRepository.add(category));
    }

    @Override
    public CategoryVO updateCategory(int id, String name, String description) {
        Category data = new Category();
        data.setName(name);
        data.setDescription(description);
        return CategoryMapper.entityToVO(this.categoryRepository.update(id, data));
    }

    @Override
    public CategoryVO showCategory(int id) {
        return CategoryMapper.entityToVO(this.categoryRepository.get(id));
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryRepository.delete(id);
    }

    @Override
    public List<CategoryVO> listAllCategories() {
        List<Category> data = categoryRepository.list();
        return CategoryMapper.entityToVO(data);
    }


    @Override
    public EventOrganizerVO addEventOrganizer(String name, String description) {
        EventOrganizer eventOrganizer = new EventOrganizer();
        eventOrganizer.setName(name);
        eventOrganizer.setDescription(description);
        return EventOrganizerMapper.entityToVO(eventOrganizerRepository.add(eventOrganizer));
    }

    @Override
    public EventOrganizerVO updateEventOrganizer(int id, String name, String description) {
        EventOrganizer eventOrganizer = new EventOrganizer();
        eventOrganizer.setName(name);
        eventOrganizer.setDescription(description);
        return EventOrganizerMapper.entityToVO(eventOrganizerRepository.update(id, eventOrganizer));
    }

    @Override
    public EventOrganizerVO showEventOrganizer(int id) {
        return EventOrganizerMapper.entityToVO(eventOrganizerRepository.get(id));
    }

    @Override
    public List<EventOrganizerVO> listAllEventOrganizers() {
        List<EventOrganizer> data = eventOrganizerRepository.list();
        return EventOrganizerMapper.entityToVO(data);
    }

    @Override
    public UserVO addAdministrator(String email, String password, String name, String surname) {

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setSurname(surname);
        user.setAdministrator(true);
        return UserMapper.entityToVO(userRepository.add(user));

    }

    @Override
    public UserVO updateAdministrator(int id, String email, String password, String name, String surname) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setSurname(surname);
        user.setAdministrator(true);
        return UserMapper.entityToVO(userRepository.update(id, user));
    }

    @Override
    public UserVO showAdministator(int id) {

        return UserMapper.entityToVO(userRepository.get(id));
    }

    @Override
    public List<UserVO> listAllAdministrators() {

        List<User> data = userRepository.list();
        var users = UserMapper.entityToVO(data);

        return users.stream().filter(user -> user.isAdministrator()).collect(Collectors.toList());

    }

    @Override
    public LabelVO addLabel(String name, String description) {
        Label label = new Label();
        label.setName(name);
        label.setDescription(description);
        return LabelMapper.entityToVO(labelRepository.add(label));
    }

    @Override
    public LabelVO updateLabel(int id, String name, String description) {

        Label label = new Label();
        label.setName(name);
        label.setDescription(description);
        return LabelMapper.entityToVO(labelRepository.update(id, label));
    }

    @Override
    public LabelVO showLabel(int id) {
        return LabelMapper.entityToVO(labelRepository.get(id));
    }

    @Override
    public List<LabelVO> listAllLabels() {
        List<Label> data = labelRepository.list();
        return LabelMapper.entityToVO(data);
    }

    @Override
    public void removeLabel(int id) {
        this.labelRepository.delete(id);
    }


}