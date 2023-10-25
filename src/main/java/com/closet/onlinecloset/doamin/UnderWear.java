package com.closet.onlinecloset.doamin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "underwear")
public class UnderWear implements Serializable{
    @TableId
    private Integer id;

    @TableField(exist = false)
    private Clothing clothing;

    @TableField(value = "clothing_id")
    private Integer clothingId;

    private String clothingLength;//衣长
    private String shoulderWidth;//肩宽
    private String bodyWidth;//身宽
    private String sleeveLength;//袖长

    @TableField(value = "waits_width")
    private String waitswidth;
    private String hips;//腰围
    @TableField(value = "pants_length")
    private String pantslength;//裤长
    @TableField(value = "pants_opening_width")
    private String pantsopeningwidth;//裤口宽

}
