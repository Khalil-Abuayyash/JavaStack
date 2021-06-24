package com.khalil.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khalil.relationships.models.Ninja;
import com.khalil.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

}
