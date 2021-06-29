package com.example.eventsBeltReviwer.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eventsBeltReviwer.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
