package com.example.music.controller;


import com.example.music.entity.Company;
import com.example.music.entity.Composer;
import com.example.music.service.ICompanyService;
import com.example.music.service.IComposerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Controller
@RequestMapping("/composer")
public class ComposerController {
    private String prefix = "composer/";
    @Autowired
    private IComposerService iComposerService;

    private static final Logger logger = LoggerFactory.getLogger(ComposerController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("composers", iComposerService.getAll(model.asMap()));
        logger.info("composer/index");
        return prefix + "indexComposer.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("composer/add");
        return prefix + "addComposer.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("gender") String gender) {
        Composer composer=new Composer();
        composer.setId(id);
        composer.setName(name);
        composer.setGender(gender);
        iComposerService.save(composer);
        logger.info("composer/add " + composer);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iComposerService.delete(id);
        logger.info("composer/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("composer", iComposerService.getById(id));
        logger.info("composer/edit " + id);
        return prefix + "editComposer.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("gender") String gender) {
        Composer composer=new Composer();
        composer.setId(id);
        composer.setName(name);
        composer.setGender(gender);
        iComposerService.updateById(composer);
        logger.info("composer/edit " + id + " " + composer);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("composers", iComposerService.getById(keyword));
        logger.info("composer/search " + keyword);
        return prefix + "indexComposer.html";
    }
}
