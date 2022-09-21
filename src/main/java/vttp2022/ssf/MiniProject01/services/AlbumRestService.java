package vttp2022.ssf.MiniProject01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.ssf.MiniProject01.models.Albums;
import vttp2022.ssf.MiniProject01.repositories.AlbumRepository;

@Service
public class AlbumRestService {
    
    @Autowired
	private AlbumRepository albumsRepo;

	public void save(List<Albums> toSave) {
		albumsRepo.save(toSave);
	}

	public Optional<Albums> get(String idAlbum) {
		return albumsRepo.get(idAlbum);
	}

}

