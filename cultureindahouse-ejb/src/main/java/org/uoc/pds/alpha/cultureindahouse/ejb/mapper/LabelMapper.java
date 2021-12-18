package org.uoc.pds.alpha.cultureindahouse.ejb.mapper;

import java.util.ArrayList;
import java.util.List;

import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Label;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;

import lombok.var;

public class LabelMapper {

    public static Label voToEntity(LabelVO labelVO) {
        Label ret = new Label();

        var id = labelVO.getId();

        if (id != null) {
            ret.setId(id);
        }
        ret.setName(labelVO.getName());
        ret.setDescription(labelVO.getDescription());

        return ret;
    }

    public static LabelVO entityToVO(Label label) {
        LabelVO ret = new LabelVO();
        ret.setId(label.getId());
        ret.setName(label.getName());
        ret.setDescription(label.getDescription());
        return ret;
    }

    public static List<LabelVO> entityToVO(List<Label> labels) {
        List<LabelVO> ret = new ArrayList<>();
        for (Label label : labels) {
            ret.add(entityToVO(label));
        }
        return ret;
    }

}
