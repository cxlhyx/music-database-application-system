package com.example.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
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
@ApiModel(value = "Album对象", description = "")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private LocalDate issueDate;

    private Integer titleSongId;

    private Integer performerId;

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
    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
    public Integer getTitleSongId() {
        return titleSongId;
    }

    public void setTitleSongId(Integer titleSongId) {
        this.titleSongId = titleSongId;
    }
    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    @Override
    public String toString() {
        return "Album{" +
            "id=" + id +
            ", name=" + name +
            ", issueDate=" + issueDate +
            ", titleSongId=" + titleSongId +
            ", performerId=" + performerId +
        "}";
    }
}
