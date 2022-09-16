package vttp2022.ssf.MiniProject01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.MiniProject01.models.Albums;
import vttp2022.ssf.MiniProject01.services.AlbumsService;



@Controller
@RequestMapping({"/albums"})
public class AlbumsController {

	@Autowired
	private AlbumsService albumsSvc;

	@GetMapping
	public String getArtistsResults(Model model, @RequestParam String artistID) {
		
		List<Albums> albums = albumsSvc.getArtistAlbums(artistID);
        //sess.setAttribute("sess", flights);
        model.addAttribute("artistID", artistID.toUpperCase());
		model.addAttribute("albums", albums);
		return "albums";
	}
} 