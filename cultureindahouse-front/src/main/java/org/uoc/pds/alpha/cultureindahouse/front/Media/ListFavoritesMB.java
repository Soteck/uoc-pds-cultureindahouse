package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.QuestionVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Console;
import java.util.List;

@SessionScoped
@ManagedBean(name = "ListFavoritesMB")
public class ListFavoritesMB {

    @EJB
    private MediaLocal favoritesLocal;

    @Getter
    @Setter
    protected Integer userId = null;
    private UserVO user;

    public List<EventVO> getFavorites() {
        return favoritesLocal.listAllFavorites(userId);
    }

}
