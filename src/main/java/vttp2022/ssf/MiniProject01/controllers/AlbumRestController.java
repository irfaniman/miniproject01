package vttp2022.ssf.MiniProject01.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2022.ssf.MiniProject01.models.Albums;
import vttp2022.ssf.MiniProject01.services.SaveService;

@RestController
@RequestMapping(path = "/albumRest", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlbumRestController {

	@Autowired
	private SaveService albSvc;

	@GetMapping(path="{idAlbum}")
	public ResponseEntity<String> getNews(@PathVariable(name="idAlbum") String idAlbum) {
		Optional<Albums> opt = albSvc.get(idAlbum);
		if (opt.isEmpty()) {
			JsonObject payload = Json.createObjectBuilder()
				.add("error", "Cannot find albums %s".formatted(idAlbum))
				.build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(payload.toString());
		}
		Albums album = opt.get();
		return ResponseEntity.ok(album.toJson().toString());
	}

}
