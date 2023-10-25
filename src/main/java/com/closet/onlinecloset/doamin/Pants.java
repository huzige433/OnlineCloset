package com.closet.onlinecloset.doamin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "pants")
public class Pants implements Serializable{
    @TableId
    private Integer id;

    @TableField(exist = false)
    private Clothing clothing;

    @TableField(value = "clothing_id")
    private Integer clothingId;

    @TableField(value = "waits_width")
    private String waitswidth;
    private String hips;//腰围
    @TableField(value = "pants_length")
    private String pantslength;//裤长
    @TableField(value = "half_thign_width")
    private String halfthignwidth;//底裆宽(1/2大腿围)
    private String crotchup;//上裆
    @TableField(value = "inseam_length")
    private String inseamlength;//裤内裆长
    @TableField(value = "pants_opening_width")
    private String pantsopeningwidth;//裤口宽

}
