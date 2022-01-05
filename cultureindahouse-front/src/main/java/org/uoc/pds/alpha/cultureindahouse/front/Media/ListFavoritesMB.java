package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ViewScoped
@ManagedBean(name = "ListFavoritesMB")
public class ListFavoritesMB {

    @EJB
    private MediaLocal favoritesLocal;

    @Getter
    @Setter
    protected Integer userId = null;

    public List<EventVO> getFavorites() {
        return favoritesLocal.listAllFavorites(userId);
    }

}
