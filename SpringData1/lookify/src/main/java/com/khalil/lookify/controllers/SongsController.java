package com.khalil.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khalil.lookify.models.Song;
import com.khalil.lookify.services.SongService;

@Controller
@RequestMapping("/")
public class SongsController {
	private final SongService songService;
	
	public SongsController(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping("")
	public String welcome() {
		return ("/songs/welcome.jsp");
	}
	
	@GetMapping("dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "songs/dashboard.jsp";
	}
	
	@GetMapping("songs/new")
	public String newBook(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}
	
	@PostMapping("songs")
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/songs/new.jsp";
		}
		else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("songs/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	@DeleteMapping("songs/{id}")
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("search/topTen")
	public String topTen(Model model) {
		List<Song> topTenSongs = songService.findTopTen();
		model.addAttribute("topTenSongs", topTenSongs);
		return "/songs/topTen.jsp";
	}
	
	@GetMapping("search")
	public String search(@RequestParam(value="q") String searched, Model model) {
		model.addAttribute("searched", searched);
		List<Song> resultSongs = songService.searchByArtist(searched);
		model.addAttribute("resultSongs", resultSongs);
		return "/songs/search.jsp";
	}
}
