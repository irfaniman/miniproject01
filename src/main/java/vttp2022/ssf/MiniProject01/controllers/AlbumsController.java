package vttp2022.ssf.MiniProject01.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.MiniProject01.models.Albums;
import vttp2022.ssf.MiniProject01.services.AlbumRestService;
import vttp2022.ssf.MiniProject01.services.AlbumsService;


@Controller
@RequestMapping({"/albums"})
public class AlbumsController {

	@Autowired
	private AlbumsService albumsSvc;

	@Autowired
	private AlbumRestService albRestSvc;

	@GetMapping
	public String getAlbums(Model model, @RequestParam String artistID) {
		
		List<Albums> albums = albumsSvc.getArtistAlbums(artistID);
        model.addAttribute("artistID", artistID.toUpperCase());
		model.addAttribute("albums", albums);
		return "albums";
	}

	@PostMapping
	public String postAlbums(@RequestBody MultiValueMap<String, String> form,
			Model model, HttpSession sess) {

		List<Albums> albums = (List<Albums>)sess.getAttribute("albums");

		List<String> saveIds = form.get("albumId");
		List<Albums> toSave = albums.stream()
			.filter(art -> {
				for (String i: saveIds)
					if (i.equals(art.getIdAlbum()))
						return true;
				return false;
			}) 
			.toList();

		if (toSave.size() > 0)
			albRestSvc.save(toSave);

		model.addAttribute("albums", albums);
		return "albums";

	}

} 