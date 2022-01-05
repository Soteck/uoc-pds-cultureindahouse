package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "AddToFavoritesMB")
public class AddToFavoritesMB {

    @EJB
    public MediaLocal mediaLocal;

    @Getter
    @Setter
    private Integer eventId;

    public void AddToFavourites(Integer userId, Integer eventId)
    {
        mediaLocal.addToFavorites(eventId,userId);
    }
}
