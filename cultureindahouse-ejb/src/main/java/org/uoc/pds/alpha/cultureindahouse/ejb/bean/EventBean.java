package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.CategoryMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.*;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.CategoryRepositoryInterface;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.EventOrganizerRepositoryInterface;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.LabelRepositoryInterface;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.UserRepositoryInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AdministrationBean implements AdministrationLocal, AdministrationRemote {

	@EJB
	private CategoryRepositoryInterface categoryRepository;
	@EJB
	private EventOrganizerRepositoryInterface eventOrganizerRepositoryInterface;
	@EJB
	private UserRepositoryInterface userRepositoryInterface;
	@EJB
	private LabelRepositoryInterface labelRepositoryInterface;


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
		data.setDescription(description);
		return CategoryMapper.entityToVO(this.categoryRepository.update(name, data));
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
		return null;
	}

	@Override
	public EventOrganizerVO updateEventOrganizer(int id, String name, String description) {
		return null;
	}

	@Override
	public EventOrganizerVO showEventOrganizer(int id) {
		return null;
	}

	@Override
	public List<EventOrganizerVO> listAllEventOrganizers() {
		return null;
	}

	@Override
	public UserVO addAdministrator(String email, String password, String name, String surname) {
		return null;
	}

	@Override
	public UserVO updateAdministrator(String email, String password, String name, String surname) {
		return null;
	}

	@Override
	public UserVO showAdministator(String email) {
		return null;
	}

	@Override
	public List<UserVO> listAllAdministrators() {
		return null;
	}

	@Override
	public LabelVO addLabel(String name, String description) {
		return null;
	}

	@Override
	public LabelVO updateLabel(int id, String name, String description) {
		return null;
	}

	@Override
	public LabelVO showLabel(int id) {
		return null;
	}

	@Override
	public List<LabelVO> listAllLabels() {
		return null;
	}

	@Override
	public void removeLabel(int id) {

	}






}
