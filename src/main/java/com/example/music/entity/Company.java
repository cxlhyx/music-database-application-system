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
@ApiModel(value = "Company对象", description = "")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String region;

    private LocalDate establishedTime;

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
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public LocalDate getEstablishedTime() {
        return establishedTime;
    }

    public void setEstablishedTime(LocalDate establishedTime) {
        this.establishedTime = establishedTime;
    }

    @Override
    public String toString() {
        return "Company{" +
            "id=" + id +
            ", name=" + name +
            ", region=" + region +
            ", establishedTime=" + establishedTime +
        "}";
    }
}
