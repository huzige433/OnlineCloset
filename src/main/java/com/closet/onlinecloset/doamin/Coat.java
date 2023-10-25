package com.closet.onlinecloset.doamin;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.io.Serializable;

@Data
@TableName(value = "coat")
public class Coat implements Serializable{
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

}
