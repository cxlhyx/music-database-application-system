package com.example.music.controller;


import com.example.music.entity.Company;
import com.example.music.entity.Singer;
import com.example.music.service.ICompanyService;
import com.example.music.service.ISingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Controller
@RequestMapping("/singer")
public class SingerController {
    private String prefix = "singer/";
    @Autowired
    private ISingerService iSingerService;

    private static final Logger logger = LoggerFactory.getLogger(SingerController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("singers", iSingerService.getAll(model.asMap()));
        logger.info("singer/index");
        return prefix + "indexSinger.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("singer/add");
        return prefix + "addSinger.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("gender") String gender,
                      @RequestParam("region") String region,
                      @RequestParam("performerId") Integer performerId) {
        Singer singer=new Singer();
        singer.setId(id);
        singer.setName(name);
        singer.setGender(gender);
        singer.setRegion(region);
        singer.setPerformerId(performerId);
        iSingerService.save(singer);
        logger.info("singer/add " + singer);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iSingerService.delete(id);
        logger.info("singer/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("singer", iSingerService.getById(id));
        logger.info("singer/edit " + id);
        return prefix + "editSinger.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("gender") String gender,
                       @RequestParam("region") String region,
                       @RequestParam("performerId") Integer performerId) {
        Singer singer=new Singer();
        singer.setId(id);
        singer.setName(name);
        singer.setGender(gender);
        singer.setRegion(region);
        singer.setPerformerId(performerId);
        iSingerService.updateById(singer);
        logger.info("singer/edit " + id + " " + singer);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("singers", iSingerService.getById(keyword));
        logger.info("singer/search " + keyword);
        return prefix + "indexSinger.html";
    }
}
