package org.endangered.miniproject.service;

import org.endangered.miniproject.model.Comments;
import org.endangered.miniproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    private CommentRepository commentRepository;

    // Method to get all comments
    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }

    // Method to get a comment by ID
    public Optional<Comments> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    // Method to add a new comment
    public Comments addComment(String author, String content) {
        Comments newComment = new Comments();
        newComment.setAuthor(author);
        newComment.setContent(content);

        return commentRepository.save(newComment);
    }

    // Method to edit an existing comment by ID
    public Comments editComment(Long id, String newContent) {
        Optional<Comments> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comments comment = optionalComment.get();
            comment.setContent(newContent);

            return commentRepository.save(comment);
        } else {
            throw new RuntimeException("Comment not found");
        }
    }

    // Method to delete a comment by ID
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
