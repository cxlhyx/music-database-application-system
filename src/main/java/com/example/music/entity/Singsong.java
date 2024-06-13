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
@ApiModel(value = "Singsong对象", description = "")
public class Singsong implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer songId;

    private Integer performerId;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }
    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    @Override
    public String toString() {
        return "Singsong{" +
            "songId=" + songId +
            ", performerId=" + performerId +
        "}";
    }
}
