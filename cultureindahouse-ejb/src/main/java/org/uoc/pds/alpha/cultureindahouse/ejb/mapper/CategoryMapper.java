package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Category;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {


    public static Category toEntity(CategoryVO categoryVO, boolean relations) {
        Category ret = new Category();

        ret.setId(categoryVO.getId());
        ret.setName(categoryVO.getName());
        ret.setDescription(categoryVO.getDescription());

        var events = categoryVO.getEvents();
        if (relations && events != null && !events.isEmpty()) {
            ret.setEvents(EventMapper.toEntity(events, false));
        }

        return ret;
    }

    public static CategoryVO toVO(Category category, boolean relations) {
        CategoryVO ret = new CategoryVO();
        ret.setId(category.getId());
        ret.setName(category.getName());
        ret.setDescription(category.getDescription());

        var events = category.getEvents();
        if (relations && events != null && !events.isEmpty()) {
            ret.setEvents(EventMapper.toVO(events, false));
        }

        return ret;
    }

    public static List<Category> toEntity(List<CategoryVO> categories, boolean relations) {
        List<Category> ret = new ArrayList<>();
        for (CategoryVO category : categories) {
            ret.add(toEntity(category, relations));
        }
        return ret;
    }

    public static List<CategoryVO> toVO(List<Category> categories, boolean relations) {
        List<CategoryVO> ret = new ArrayList<>();
        for (Category category : categories) {
            ret.add(toVO(category, relations));
        }
        return ret;
    }


}
