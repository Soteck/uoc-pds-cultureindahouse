package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.OrderHistory;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.OrderHistoryVO;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryMapper {

    public static OrderHistory toEntity(OrderHistoryVO orderHistoryVO, boolean relations) {
        OrderHistory ret = new OrderHistory();

        ret.setId(orderHistoryVO.getId());
        ret.setDate(orderHistoryVO.getDate());

        var event = orderHistoryVO.getEvent();
        if (relations && event != null){
            ret.setEvent(EventMapper.toEntity(event, false));
        }

        var user = orderHistoryVO.getUser();
        if (relations && user != null){
            ret.setUser(UserMapper.toEntity(user, false));
        }


        return ret;
    }

    public static OrderHistoryVO toVO(OrderHistory order, boolean relations) {
        OrderHistoryVO ret = new OrderHistoryVO();

        ret.setId(order.getId());

        ret.setDate(order.getDate());

        var event = order.getEvent();
        if (relations && event != null){
            ret.setEvent(EventMapper.toVO(event, false));
        }

        var user = order.getUser();
        if (relations && user != null){
            ret.setUser(UserMapper.toVO(user, false));
        }


        return ret;
    }


    public static List<OrderHistory> toEntity(List<OrderHistoryVO> events, boolean relations) {
        List<OrderHistory> ret = new ArrayList<>();
        for (OrderHistoryVO event : events) {
            ret.add(toEntity(event, relations));
        }
        return ret;
    }

    public static List<OrderHistoryVO> toVO(List<OrderHistory> events, boolean relations) {
        List<OrderHistoryVO> ret = new ArrayList<>();
        for (OrderHistory event : events) {
            ret.add(toVO(event, relations));
        }
        return ret;
    }
}
