package com.closet.onlinecloset.controller;


import com.closet.onlinecloset.doamin.Closet;
import com.closet.onlinecloset.services.impl.ClosetServiceImpl;
import javafx.scene.control.Separator;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static java.io.File.separator;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ClosetController {


    private final ClosetServiceImpl closetServiceImpl;

    public ClosetController(ClosetServiceImpl closetServiceImpl) {
        this.closetServiceImpl = closetServiceImpl;
    }


    @GetMapping("/list")
    public List<?> list(){
        List<?> closets= closetServiceImpl.list();
        return closets;
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody Closet closet){
        return closetServiceImpl.saveOrUpdate(closet);
    }

    @PostMapping("/Base64Toimg2")
    public String Base64Toimg2(@RequestBody JSONObject jsonObject){
        String base64Data=jsonObject.getString("base64Data");
        String imgName=jsonObject.getString("base64Data");
        String currentWorkingDirectory = System.getProperty("user.dir");
        String tempurl=currentWorkingDirectory+ separator+"imgfile"+separator+ imgName +  ".jpg";
        Boolean bl = utools.GenerateImage(base64Data.replaceAll("data:image/png;base64,",""), tempurl);
        return tempurl;
    }

}
