package com.example.MedBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by uuuu on 4/4/2018.
 */

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {
}
