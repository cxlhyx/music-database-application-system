package com.example.music.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.music.entity.Company;
import com.example.music.service.ICompanyService;
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
@RequestMapping("/company")
public class CompanyController {
    private String prefix = "company/";
    @Autowired
    private ICompanyService iCompanyService;

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("companys", iCompanyService.getAll(model.asMap()));
        logger.info("company/index");
        return prefix + "indexCompany.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("company/add");
        return prefix + "addCompany.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("region") String region,
                      @RequestParam("establishedTime") LocalDate establishedTime) {
        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setRegion(region);
        company.setEstablishedTime(establishedTime);
        iCompanyService.save(company);
        logger.info("company/add " + company);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iCompanyService.delete(id);
        logger.info("company/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", iCompanyService.getById(id));
        logger.info("company/edit " + id);
        return prefix + "editCompany.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("region") String region,
                       @RequestParam("establishedTime") LocalDate establishedTime) {
        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setRegion(region);
        company.setEstablishedTime(establishedTime);
        iCompanyService.updateById(company);
        logger.info("company/edit " + id + " " + company);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("companys", iCompanyService.getById(keyword));
        logger.info("company/search " + keyword);
        return prefix + "indexCompany.html";
    }
}
