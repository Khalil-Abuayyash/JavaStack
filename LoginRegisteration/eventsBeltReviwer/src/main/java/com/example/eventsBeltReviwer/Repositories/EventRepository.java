package com.example.eventsBeltReviwer.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eventsBeltReviwer.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

}
