package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.EventLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.*;

@SessionScoped
@ManagedBean(name = "FindEventMB")
public class FindEventMB {

    @EJB
    private EventLocal eventLocal;
    @EJB
    private AdministrationLocal adminLocal;

    @Getter @Setter
    private String selectedCategory = "-1";
    @Getter @Setter
    private String selectedLabel = "-1";
    @Getter @Setter
    private String filterType = "0";
    @Getter @Setter
    private String filterName = "";

    public List<SelectItem> getCategories()
    {
        List<SelectItem> categoies = new ArrayList<>();

        for(CategoryVO cat : adminLocal.listAllCategories())
        {
            categoies.add( new SelectItem(cat.getId(),cat.getId() + " - " +cat.getName()));
        }

        return categoies;
    }

    public List<SelectItem> getLabels()
    {
        List<SelectItem> labels = new ArrayList<>();

        for(LabelVO lab : adminLocal.listAllLabels())
        {
            labels.add( new SelectItem(lab.getId(), lab.getId() + " - " +lab.getName()));
        }

        return labels;
    }

    public List<SelectItem> getFilterTypes()
    {
        List<SelectItem> filterTypes = new ArrayList<>();

        filterTypes.add( new SelectItem("0","All"));
        filterTypes.add( new SelectItem("1","Name"));
        filterTypes.add( new SelectItem("2","Category"));
        filterTypes.add( new SelectItem("3","Label"));

        return filterTypes;
    }

    public List<EventVO> getEvents()
    {
        List<EventVO> result = new ArrayList<>();
        switch (this.filterType)
        {
            case "0":
                result = eventLocal.listAllEvents();
                break;
            case "1":
                if( this.filterName!= null && !this.filterName.isEmpty())
                    result = eventLocal.findEventsByName(this.filterName);
                break;
            case "2":
                if( this.selectedCategory.equals("-1"))
                    result = eventLocal.findEventsByCategory(Integer.parseInt(this.selectedCategory));
                break;
            case "3":
                if( this.selectedLabel.equals("-1"))
                    result =  eventLocal.findEventsByLabel(Integer.parseInt(this.selectedLabel));
                break;
        }
        return result;
    }
}
