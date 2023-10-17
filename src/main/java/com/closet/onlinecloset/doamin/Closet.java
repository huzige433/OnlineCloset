package com.closet.onlinecloset.doamin;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "closet")
public class Closet implements Serializable{
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String descript;
    private String url;
    @TableField(value = "src_list")
    private String  srcList;


}
