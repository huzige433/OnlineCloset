package com.closet.onlinecloset.doamin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("clothing")
public class Clothing implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;//名字
    private String size;//尺码
    private String url;//图片链接
    @TableField(value = "src_list")
    private String srcList;//更多图片
    private String descript;//其他描述
    private double price;//价格
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date buytime;//购买时间
    private Integer season;//春0夏1秋冬2
    private Integer type;//元属性type,0衣服1裤子2内衣3鞋子
    private Integer userid;//用户id
    private Integer isactive;//-1丢弃



}
