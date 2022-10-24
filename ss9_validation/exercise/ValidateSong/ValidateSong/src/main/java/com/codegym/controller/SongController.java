package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping
    public String showSongList(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/song/list";
    }

    @GetMapping("/add")
    public String showAddSong(Model model) {
       model.addAttribute("songDto", new SongDto());
       return "/song/add";
    }
    @PostMapping("/add")
    public String add(@Validated @ModelAttribute SongDto songDto,
                      BindingResult bindingResult,Model model,
                      RedirectAttributes redirectAttributes) {

        new SongDto().validate(songDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute(songDto);
            return "/song/add";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        String performanceArtistFormat = pAFormat(song.getPerformanceArtist());
        song.setPerformanceArtist(performanceArtistFormat);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Add new Ok!");
        return "redirect:/song";
    }

    private String pAFormat(String performanceArtist) {
        String regex = "[^\\w,\\s]";
        return performanceArtist.replaceAll(regex, "");

    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "/song/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        new SongDto().validate(songDto, bindingResult);
        if(bindingResult.hasErrors()) {
            model.addAttribute(songDto);
            return "/song/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        String performanceArtistFormat = pAFormat(song.getPerformanceArtist());
        song.setPerformanceArtist(performanceArtistFormat);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message", "Update Ok!");
        return "redirect:/song";
    }

    public static void main(String[] args) {
        System.out.println( "hello: " + new SongController().pAFormat("$%^&&abdbsa,dsada"));
    }
}
