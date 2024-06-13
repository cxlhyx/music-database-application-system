package com.example.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
@ApiModel(value = "Song对象", description = "")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String style;

    private LocalDate issueDate;

    private LocalTime duration;

    private Integer lyricistId;

    private Integer composerId;

    private Integer albumId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
    public Integer getLyricistId() {
        return lyricistId;
    }

    public void setLyricistId(Integer lyricistId) {
        this.lyricistId = lyricistId;
    }
    public Integer getComposerId() {
        return composerId;
    }

    public void setComposerId(Integer composerId) {
        this.composerId = composerId;
    }
    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Song{" +
            "id=" + id +
            ", name=" + name +
            ", style=" + style +
            ", issueDate=" + issueDate +
            ", duration=" + duration +
            ", lyricistId=" + lyricistId +
            ", composerId=" + composerId +
            ", albumId=" + albumId +
        "}";
    }
}
