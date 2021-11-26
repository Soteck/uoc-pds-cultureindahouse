package org.uoc.pds.alpha.cultureindahouse.ejb.bean;

import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CategoryRemote {

	CategoryVO add(String name, String description);

	List<CategoryVO> list();

	void delete(String name);

	CategoryVO update(String name, String description);

	CategoryVO findByName(String name);

}
