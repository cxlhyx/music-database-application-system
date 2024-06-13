package com.example.music.controller;


import com.example.music.entity.Singsong;
import com.example.music.service.ISingsongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Controller
@RequestMapping("/singsong")
public class SingsongController {
    private String prefix = "singsong/";
    @Autowired
    private ISingsongService iSingsongService;

    private static final Logger logger = LoggerFactory.getLogger(SingsongController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("singsongs", iSingsongService.getAll(model.asMap()));
        logger.info("singsong/index");
        return prefix + "indexSingsong.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("singsong/add");
        return prefix + "addSingsong.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("songId") Integer songId,
                      @RequestParam("performerId") Integer performerId) {
        Singsong singsong = new Singsong();
        singsong.setSongId(songId);
        singsong.setPerformerId(performerId);
        iSingsongService.save(singsong);
        logger.info("singsong/add " + singsong);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{songId}/{performerId}")
    public String delete(@PathVariable("songId") Integer songId,
                         @PathVariable("performerId") Integer performerId,
                         Model model) {
        Map<String, Object> map = model.asMap();
        map.put("songId", songId);
        map.put("performerId", performerId);
        iSingsongService.delete(map);
        logger.info("singsong/delete " + songId + " " + performerId);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{songId}/{performerId}")
    public String showEdit(@PathVariable("songId") Integer songId,
                           @PathVariable("performerId") Integer performerId,
                           Model model) {
        Map<String, Object> map = model.asMap();
        map.put("songId", songId);
        map.put("performerId", performerId);
        model.addAttribute("singsong", iSingsongService.get(map));
        logger.info("singsong/edit " + songId + " " + performerId);
        return prefix + "editSingsong.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("songId") Integer songId,
                       @RequestParam("performerId") Integer performerId,
                       @RequestParam("new_songId") Integer new_songId,
                       @RequestParam("new_performerId") Integer new_performerId,
                       Model model) {
        Map<String, Object> map = model.asMap();
        map.put("songId", songId);
        map.put("performerId", performerId);
        map.put("new_songId", new_songId);
        map.put("new_performerId", new_performerId);
        iSingsongService.edit(map);
        logger.info("singsong/edit " + songId + " " + performerId);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("songId") Integer songId,
                                @RequestParam("performerId") Integer performerId,
                                Model model) {
        Map<String, Object> map = model.asMap();
        map.put("songId", songId);
        map.put("performerId", performerId);
        model.addAttribute("singsongs", iSingsongService.get(map));
        logger.info("singsong/search " + songId + " " + performerId);
        return prefix + "indexSingsong.html";
    }
}
