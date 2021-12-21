package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import lombok.var;

public class UserMapper {

    public static User voToEntity(UserVO userVO) {
        User ret = new User();

        var id = userVO.getId();

        if (id != null) {
            ret.setId(id);
        }

        ret.setEmail(userVO.getEmail());
        ret.setPassword(userVO.getPassword());
        ret.setName(userVO.getName());
        ret.setSurname(userVO.getSurname());
        ret.setNif(userVO.getNif());
        ret.setPreferedLanguage(userVO.getPreferedLanguage());
        ret.setAddress(userVO.getAddress());
        ret.setAdministrator(userVO.isAdministrator());

        return ret;
    }

    public static UserVO entityToVO(User user) {
        UserVO ret = new UserVO();

        ret.setId(user.getId());
        ret.setEmail(user.getEmail());
        ret.setPassword(user.getPassword());
        ret.setName(user.getName());
        ret.setSurname(user.getSurname());
        ret.setNif(user.getNif());
        ret.setPreferedLanguage(user.getPreferedLanguage());
        ret.setAddress(user.getAddress());
        ret.setAdministrator(user.isAdministrator());
        return ret;
    }

    public static List<UserVO> entityToVO(List<User> categories) {
        List<UserVO> ret = new ArrayList<>();
        for (User User : categories) {
            ret.add(entityToVO(User));
        }
        return ret;
    }

}
