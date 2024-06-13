package com.example.music.controller;


import com.example.music.entity.Band;
import com.example.music.entity.Company;
import com.example.music.service.IBandService;
import com.example.music.service.ICompanyService;
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
@RequestMapping("/band")
public class BandController {
    private String prefix = "band/";
    @Autowired
    private IBandService iBandService;

    private static final Logger logger = LoggerFactory.getLogger(BandController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("bands", iBandService.getAll(model.asMap()));
        logger.info("band/index");
        return prefix + "indexBand.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("band/add");
        return prefix + "addBand.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("region") String region,
                      @RequestParam("performerId") Integer performerId) {
        Band band = new Band();
        band.setId(id);
        band.setName(name);
        band.setRegion(region);
        band.setPerformerId(performerId);
        iBandService.save(band);
        logger.info("band/add " + band);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iBandService.delete(id);
        logger.info("band/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("band", iBandService.getById(id));
        logger.info("band/edit " + id);
        return prefix + "editBand.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("region") String region,
                       @RequestParam("performerId") Integer performerId) {
        Band band = new Band();
        band.setId(id);
        band.setName(name);
        band.setRegion(region);
        band.setPerformerId(performerId);
        iBandService.updateById(band);
        logger.info("band/edit " + id + " " + band);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("bands", iBandService.getById(keyword));
        logger.info("band/search " + keyword);
        return prefix + "indexBand.html";
    }
}
