package org.endangered.miniproject.repository;
import org.endangered.miniproject.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, Long> {
}

