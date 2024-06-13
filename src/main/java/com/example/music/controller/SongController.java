package com.example.music.controller;


import com.example.music.entity.Company;
import com.example.music.entity.Song;
import com.example.music.service.ICompanyService;
import com.example.music.service.ISongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxlhyx
 * @since 2024-5-31
 */
@Controller
@RequestMapping("/song")
public class SongController {
    private String prefix = "song/";
    @Autowired
    private ISongService iSongService;

    private static final Logger logger = LoggerFactory.getLogger(SongController.class);

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("songs", iSongService.getAll(model.asMap()));
        logger.info("song/index");
        return prefix + "indexSong.html";
    }

    @GetMapping("/add")
    public String showAdd() {
        logger.info("song/add");
        return prefix + "addSong.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam("id") Integer id,
                      @RequestParam("name") String name,
                      @RequestParam("style") String style,
                      @RequestParam("issueDate") LocalDate issueDate,
                      @RequestParam("duration") LocalTime duration,
                      @RequestParam("lyricistId") Integer lyricistId,
                      @RequestParam("composerId") Integer composerId,
                      @RequestParam("albumId") Integer albumId) {
        Song song=new Song();
        song.setId(id);
        song.setName(name);
        song.setStyle(style);
        song.setIssueDate(issueDate);
        song.setDuration(duration);
        song.setLyricistId(lyricistId);
        song.setComposerId(composerId);
        song.setAlbumId(albumId);
        iSongService.save(song);
        logger.info("song/add " + song);
        return "redirect:/" + prefix + "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        iSongService.delete(id);
        logger.info("song/delete " + id);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("song", iSongService.getById(id));
        logger.info("song/edit " + id);
        return prefix + "editSong.html";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("id") Integer id,
                       @RequestParam("name") String name,
                       @RequestParam("style") String style,
                       @RequestParam("issueDate") LocalDate issueDate,
                       @RequestParam("duration") LocalTime duration,
                       @RequestParam("lyricistId") Integer lyricistId,
                       @RequestParam("composerId") Integer composerId,
                       @RequestParam("albumId") Integer albumId) {
        Song song=new Song();
        song.setId(id);
        song.setName(name);
        song.setStyle(style);
        song.setIssueDate(issueDate);
        song.setDuration(duration);
        song.setLyricistId(lyricistId);
        song.setComposerId(composerId);
        song.setAlbumId(albumId);
        iSongService.updateById(song);
        logger.info("song/edit " + id + " " + song);
        return "redirect:/" + prefix + "index";
    }

    @GetMapping("/search")
    public String searchRecords(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("songs", iSongService.getById(keyword));
        logger.info("song/search " + keyword);
        return prefix + "indexSong.html";
    }
}
