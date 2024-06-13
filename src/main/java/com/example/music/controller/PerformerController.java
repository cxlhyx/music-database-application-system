package com.example.music.controller;


import com.example.music.entity.Company;
import com.example.music.entity.Performer;
import com.example.music.service.ICompanyService;
import com.example.music.service.IPerformerService;
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
@RequestMapping("/performer")
public class PerformerController {
    private String prefix = "performer/";
    @Autowired
    private IPerformerService iPerformerService;

    private static final Logger logger = LoggerFactory.getLogger(PerformerController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("performers", iPerformerService.getAll(model.asMap()));
        logger.info("performer/index");
        return prefix + "indexPerformer.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("performer/add");
        return prefix + "addPerformer.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("companyId") Integer companyId) {
        Performer performer =new Performer();
        performer.setId(id);
        performer.setCompanyId(companyId);
        iPerformerService.save(performer);
        logger.info("performer/add " + performer);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iPerformerService.delete(id);
        logger.info("performer/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("performer", iPerformerService.getById(id));
        logger.info("performer/edit " + id);
        return prefix + "editPerformer.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("companyId") Integer companyId) {
        Performer performer =new Performer();
        performer.setId(id);
        performer.setCompanyId(companyId);
        iPerformerService.updateById(performer);
        logger.info("performer/edit " + id + " " + performer);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("performers", iPerformerService.getById(keyword));
        logger.info("performer/search " + keyword);
        return prefix + "indexPerformer.html";
    }
}
