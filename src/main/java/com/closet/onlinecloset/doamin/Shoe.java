package com.closet.onlinecloset.doamin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "shoe")
public class Shoe implements Serializable{
    @TableId
    private Integer id;

    @TableField(exist = false)
    private Clothing clothing;

    @TableField(value = "clothing_id")
    private Integer clothingId;

}
