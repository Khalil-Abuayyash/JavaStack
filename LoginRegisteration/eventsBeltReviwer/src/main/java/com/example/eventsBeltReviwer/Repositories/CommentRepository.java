package com.example.eventsBeltReviwer.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eventsBeltReviwer.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

}
