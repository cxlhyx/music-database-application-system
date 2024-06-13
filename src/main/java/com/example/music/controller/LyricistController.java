package com.example.music.controller;


import com.example.music.entity.Company;
import com.example.music.entity.Lyricist;
import com.example.music.service.ICompanyService;
import com.example.music.service.ILyricistService;
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
@RequestMapping("/lyricist")
public class LyricistController {
    private String prefix = "lyricist/";
    @Autowired
    private ILyricistService iLyricistService;

    private static final Logger logger = LoggerFactory.getLogger(LyricistController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("lyricists", iLyricistService.getAll(model.asMap()));
        logger.info("lyricist/index");
        return prefix + "indexLyricist.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("lyricist/add");
        return prefix + "addLyricist.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("gender") String gender) {
        Lyricist lyricist=new Lyricist();
        lyricist.setId(id);
        lyricist.setName(name);
        lyricist.setGender(gender);
        iLyricistService.save(lyricist);
        logger.info("lyricist/add " + lyricist);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iLyricistService.delete(id);
        logger.info("lyricist/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("lyricist", iLyricistService.getById(id));
        logger.info("lyricist/edit " + id);
        return prefix + "editLyricist.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("gender") String gender) {
        Lyricist lyricist=new Lyricist();
        lyricist.setId(id);
        lyricist.setName(name);
        lyricist.setGender(gender);
        iLyricistService.updateById(lyricist);
        logger.info("lyricist/edit " + id + " " + lyricist);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("lyricists", iLyricistService.getById(keyword));
        logger.info("lyricist/search " + keyword);
        return prefix + "indexLyricist.html";
    }
}
