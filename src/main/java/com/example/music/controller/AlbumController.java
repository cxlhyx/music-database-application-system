package com.example.music.controller;


import com.example.music.entity.Album;
import com.example.music.service.IAlbumService;
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
@RequestMapping("/album")
public class AlbumController {
    private String prefix = "album/";
    @Autowired
    private IAlbumService iAlbumService;

    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("albums", iAlbumService.getAll(model.asMap()));
        logger.info("album/index");
        return prefix + "indexAlbum.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("album/add");
        return prefix + "addAlbum.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("issueDate") LocalDate issueDate,
                      @RequestParam(value = "titleSongId", required = false) Integer titleSongId,
                      @RequestParam("performerId") Integer performerId) {
        Album album = new Album();
        album.setId(id);
        album.setName(name);
        album.setIssueDate(issueDate);
        album.setTitleSongId(titleSongId);
        album.setPerformerId(performerId);
        iAlbumService.save(album);
        logger.info("album/add " + album);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iAlbumService.delete(id);
        logger.info("album/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("album", iAlbumService.getById(id));
        logger.info("album/edit " + id);
        return prefix + "editAlbum.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("issueDate") LocalDate issueDate,
                       @RequestParam("titleSongId") Integer titleSongId,
                       @RequestParam("performerId") Integer performerId) {
        Album album = new Album();
        album.setId(id);
        album.setName(name);
        album.setIssueDate(issueDate);
        album.setTitleSongId(titleSongId);
        album.setPerformerId(performerId);
        iAlbumService.updateById(album);
        logger.info("album/edit " + id + " " + album);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("albums", iAlbumService.getById(keyword));
        logger.info("album/search " + keyword);
        return prefix + "indexAlbum.html";
    }
}
