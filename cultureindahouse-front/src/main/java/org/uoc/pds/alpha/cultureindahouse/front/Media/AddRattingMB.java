package org.uoc.pds.alpha.cultureindahouse.front.Media;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

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
    private String ratting = "0";

    public String AddRatting(Integer userId)
    {

        mediaLocal.addRating(eventId,userId,Integer.parseInt(ratting));
        return "FindOrdersView.xhtml";
    }

    public List<SelectItem> getRattings()
    {
        List<SelectItem> rattings = new ArrayList<>();

        rattings.add( new SelectItem("0","0"));
        rattings.add( new SelectItem("1","1"));
        rattings.add( new SelectItem("2","2"));
        rattings.add( new SelectItem("3","3"));
        rattings.add( new SelectItem("4","4"));
        rattings.add( new SelectItem("5","5"));

        return rattings;
    }

}
