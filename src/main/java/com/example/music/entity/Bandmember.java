package com.example.music.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@ApiModel(value = "Bandmember对象", description = "")
public class Bandmember implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bandId;

    private Integer singerId;

    public Integer getBandId() {
        return bandId;
    }

    public void setBandId(Integer bandId) {
        this.bandId = bandId;
    }
    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    @Override
    public String toString() {
        return "Bandmember{" +
            "bandId=" + bandId +
            ", singerId=" + singerId +
        "}";
    }
}
