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

import vttp2022.ssf.MiniProject01.models.Artist;
import vttp2022.ssf.MiniProject01.services.ArtistService;


@Controller
@RequestMapping({"/artist"})
public class ArtistsController {

	@Autowired 
	private ArtistService artistsSvc;

	@GetMapping
	public String getArtistsResults(Model model, @RequestParam String artistInput, HttpSession sess) {

		List<Artist> artist = artistsSvc.getArtist(artistInput);
		sess.setAttribute("artist", artist);
		model.addAttribute("artistInput", artistInput.toUpperCase());
		model.addAttribute("artist", artist);
		return "artist";

	}

	@PostMapping
    public String postGreetings(@RequestBody MultiValueMap<String, String> form,
        Model model, HttpSession sess) {

			List<Artist> artist = (List<Artist>)sess.getAttribute("artist");
            String name = form.getFirst("name");
            model.addAttribute("name", name);
			model.addAttribute("artist", artist);
            return "list";
    }

	
}

