package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import java.util.ArrayList;
import java.util.List;

public class LabelMapper {

    public static Label toEntity(LabelVO labelVO) {
        Label ret = new Label();

        ret.setId(labelVO.getId());
        ret.setName(labelVO.getName());
        ret.setDescription(labelVO.getDescription());

        var events = labelVO.getEvents();
        if (events != null && !events.isEmpty()) {
            ret.setEvents(EventMapper.toEntity(events));
        }

        return ret;
    }

    public static LabelVO toVO(Label label) {
        LabelVO ret = new LabelVO();

        ret.setId(label.getId());
        ret.setName(label.getName());
        ret.setDescription(label.getDescription());

        var events = label.getEvents();

        if (events != null && !events.isEmpty()) {
            ret.setEvents(EventMapper.toVO(new ArrayList<>( events)));
        }
        return ret;
    }


    public static List<Label> toEntity(List<LabelVO> labels) {
        List<Label> ret = new ArrayList<>();
        for (LabelVO label : labels) {
            ret.add(toEntity(label));
        }
        return ret;
    }

    public static List<LabelVO> toVO(List<Label> labels) {
        List<LabelVO> ret = new ArrayList<>();
        for (Label label : labels) {
            ret.add(toVO(label));
        }
        return ret;
    }

}
