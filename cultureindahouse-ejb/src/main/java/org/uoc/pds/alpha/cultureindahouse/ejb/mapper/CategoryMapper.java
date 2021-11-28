package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Profile;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.ProfileVO;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {



    public static CategoryVO entityToVO(Category category) {
        CategoryVO ret = new CategoryVO();
        ret.setName(category.getName());
        ret.setDescription(category.getDescription());
        return ret;
    }

    public static List<CategoryVO> entityToVO(List<Category> categories) {
        List<CategoryVO> ret = new ArrayList<>();
        for (Category category : categories) {
            ret.add(entityToVO(category));
        }
        return ret;
    }


}
