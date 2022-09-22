package vttp2022.ssf.MiniProject01.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.ssf.MiniProject01.models.Albums;
import vttp2022.ssf.MiniProject01.models.Artist;
import vttp2022.ssf.MiniProject01.services.SaveService;
import vttp2022.ssf.MiniProject01.services.SongService;

@Controller
@RequestMapping
public class SongController {

	@Autowired 
	private SongService songSvc;

	@Autowired
	private SaveService saveSvc;


	@GetMapping(path={"/artist"})
	public String getArtist(Model model, @RequestParam String artistInput, @RequestParam String name, HttpSession sess) {
  
        List<Artist> artist = songSvc.getArtist(artistInput);
		sess.setAttribute("artistInput", artistInput.toUpperCase());
		sess.setAttribute("artist", artist);
		sess.setAttribute("name", name.toUpperCase());
		model.addAttribute("name", name.toUpperCase());
		model.addAttribute("artistInput", artistInput.toUpperCase());
		model.addAttribute("artist", artist);
		return "artist";

    }


	@GetMapping(path={"/albums"})
	public String getAlbums(Model model, @RequestParam String artistID, HttpSession sess) {
		   
		String name = (String)sess.getAttribute("name"); 
		List<Artist> artist = (List<Artist>)sess.getAttribute("artist");
		List<Albums> albums = songSvc.getAlbums(artistID);
		sess.setAttribute("artistID", artistID.toUpperCase());
		sess.setAttribute("albums", albums);
        model.addAttribute("artistID", artistID.toUpperCase());
		model.addAttribute("albums", albums);
		return "albums";
	}


	// @PostMapping
	// public String postAlbums(@RequestBody MultiValueMap<String, String> form,
	// 		Model model, HttpSession sess) {

    //     String name = (String)sess.getAttribute("name"); 
    //     List<Artist> artist = (List<Artist>)sess.getAttribute("artist");
	// 	List<Albums> albums = (List<Albums>)sess.getAttribute("albums");

	// 	List<String> saveIds = form.get("albumId");
	// 	List<Albums> toSave = albums.stream()
	// 		.filter(art -> {
	// 			for (String i: saveIds)
	// 				if (i.equals(art.getIdAlbum()))
	// 					return true;
	// 			return false;
	// 		}) 
	// 		.toList();

	// 	if (toSave.size() > 0)
	// 		saveSvc.save(toSave);
        
    //     model.addAttribute("name", name);
    //     model.addAttribute("artist", artist);
	// 	model.addAttribute("albums", albums);
	// 	return "albums";

	// }



}
