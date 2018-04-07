package com.example.MedBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;

/**
 * Created by uuuu on 4/4/2018.
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
