package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.EventLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ShowOrderMB")
public class ShowOrderMB {

    @EJB
    private EventLocal eventLocal;

    @Getter
    @Setter
    private Integer orderId = null;

    public OrderHistoryVO getOrder(){
        return eventLocal.showOrder(orderId);
    }

}
