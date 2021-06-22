package com.khalil.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khalil.lookify.models.Song;
import com.khalil.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	public Song createSong(Song song) {
		return songRepository.save(song);
	}

	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		}
		return null;
	}

	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

	public List<Song> findTopTen() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public List<Song> searchByArtist(String search) {
		return songRepository.findByArtistContaining(search);
	}

}
