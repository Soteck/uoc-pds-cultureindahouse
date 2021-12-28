package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import lombok.var;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Event;
import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LabelMapper {

    public static Label toEntity(LabelVO labelVO, boolean relations) {
        Label ret = new Label();

        ret.setId(labelVO.getId());
        ret.setName(labelVO.getName());
        ret.setDescription(labelVO.getDescription());

        var events = labelVO.getEvents();
        if (relations && events != null && !events.isEmpty()) {
            ret.setEvents(EventMapper.toEntity(events, false));
        }

        return ret;
    }

    public static LabelVO toVO(Label label, boolean relations) {
        LabelVO ret = new LabelVO();

        ret.setId(label.getId());
        ret.setName(label.getName());
        ret.setDescription(label.getDescription());

        var events = label.getEvents();

        if (relations && events != null && !events.isEmpty()) {
            ret.setEvents(EventMapper.toVO(events, false));
        }
        return ret;
    }



    public static List<Label> toEntity(Collection<LabelVO> labels, boolean relations) {
        List<Label> ret = new ArrayList<>();
        for (LabelVO label : labels) {
            ret.add(toEntity(label, relations));
        }
        return ret;
    }

    public static List<LabelVO> toVO(Collection<Label> labels, boolean relations) {

        List<LabelVO> ret = new ArrayList<>();
        for (Label label : labels) {
            ret.add(toVO(label, relations));
        }
        return ret;
    }

}
