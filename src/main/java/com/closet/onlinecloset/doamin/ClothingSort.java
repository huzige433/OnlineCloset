package com.closet.onlinecloset.doamin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("clothing_sort")
public class ClothingSort {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer type;
    @TableField("sortArry")
    private String sortarry;
    private Integer userid;
}
