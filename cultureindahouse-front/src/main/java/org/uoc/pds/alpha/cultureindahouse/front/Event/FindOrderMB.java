package org.uoc.pds.alpha.cultureindahouse.front.Event;

import lombok.Getter;
import lombok.Setter;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.EventLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ViewScoped
@ManagedBean(name = "FindOrderMB")
public class FindOrderMB {

    @EJB
    private EventLocal eventLocal;

    @Getter @Setter
    private String userEmail;

    public List<OrderHistoryVO> getOrders()
    {
        //TODO: Pasar como patrámetro el id del usuario
        return eventLocal.findOrdersByUser(71);
    }

}
