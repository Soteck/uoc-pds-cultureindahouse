package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "AddRattingMB")
public class AddRattingMB {

    @EJB
    public MediaLocal mediaLocal;

    @Getter
    @Setter
    private Integer eventId;

    @Getter
    @Setter
    private Integer ratting;

    public void AddRatting(Integer userId)
    {
        mediaLocal.addRating(eventId,userId,ratting);
    }

}
