package org.uoc.pds.alpha.cultureindahouse.ejb.pojo;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryVO implements Serializable {

	private Integer id;

	private String name;

	private String description;

}
