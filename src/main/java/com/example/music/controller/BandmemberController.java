package com.example.music.controller;


import com.example.music.entity.Bandmember;
import com.example.music.service.IBandmemberService;
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
@RequestMapping("/bandmember")
public class BandmemberController {
    private String prefix = "bandmember/";
    @Autowired
    private IBandmemberService iBandmemberService;

    private static final Logger logger = LoggerFactory.getLogger(BandmemberController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("bandmembers", iBandmemberService.getAll(model.asMap()));
        logger.info("bandmember/index");
        return prefix + "indexBandmember.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("bandmember/add");
        return prefix + "addBandmember.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("bandId") Integer bandId,
                      @RequestParam("singerId") Integer singerId) {
        Bandmember bandmember = new Bandmember();
        bandmember.setBandId(bandId);
        bandmember.setSingerId(singerId);
        iBandmemberService.save(bandmember);
        logger.info("bandmember/add " + bandmember);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{bandId}/{singerId}")
    public String delete(@PathVariable("bandId") Integer bandId,
                         @PathVariable("singerId") Integer singerId,
                         Model model) {
        Map<String, Object> map = model.asMap();
        map.put("bandId", bandId);
        map.put("singerId", singerId);
        iBandmemberService.delete(map);
        logger.info("bandmember/delete " + bandId + " " + singerId);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{bandId}/{singerId}")
    public String showEdit(@PathVariable("bandId") Integer bandId,
                           @PathVariable("singerId") Integer singerId,
                           Model model) {
        Map<String, Object> map = model.asMap();
        map.put("bandId", bandId);
        map.put("singerId", singerId);
        model.addAttribute("bandmember", iBandmemberService.get(map));
        logger.info("bandmember/edit " + bandId + " " + singerId);
        return prefix + "editBandmember.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("bandId") Integer bandId,
                       @RequestParam("singerId") Integer singerId,
                       @RequestParam("new_bandId") Integer new_bandId,
                       @RequestParam("new_singerId") Integer new_singerId,
                       Model model) {
        Map<String, Object> map = model.asMap();
        map.put("bandId", bandId);
        map.put("singerId", singerId);
        map.put("new_bandId", new_bandId);
        map.put("new_singerId", new_singerId);
        iBandmemberService.edit(map);
        logger.info("bandmember/edit " + bandId + " " + singerId);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("bandId") Integer bandId,
                                @RequestParam("singerId") Integer singerId,
                                Model model) {
        Map<String, Object> map = model.asMap();
        map.put("bandId", bandId);
        map.put("singerId", singerId);
        model.addAttribute("bandmembers", iBandmemberService.get(map));
        logger.info("bandmember/search " + bandId + " " + singerId);
        return prefix + "indexBandmember.html";
    }
}
