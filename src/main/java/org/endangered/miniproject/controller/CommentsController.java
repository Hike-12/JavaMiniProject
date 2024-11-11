package org.endangered.miniproject.controller;

import org.endangered.miniproject.model.Comments;
import org.endangered.miniproject.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    // Get all comments
    @GetMapping
    public String getAllComments(Model model) {
        List<Comments> comments = commentsService.getAllComments();
        model.addAttribute("comments", comments);
        return "comments"; // This refers to the Thymeleaf template (comments.html)
    }

    // Get comment by ID
    @GetMapping("/{id}")
    public String getCommentById(@PathVariable Long id, Model model) {
        return commentsService.getCommentById(id)
                .map(comment -> {
                    model.addAttribute("comment", comment);
                    return "comment"; // Template for displaying a single comment (comment.html)
                })
                .orElse("redirect:/comments"); // Redirect to list if not found
    }

    // Add a new comment
    @PostMapping
    public String addComment(@RequestParam String author, @RequestParam String content) {
        commentsService.addComment(author, content);
        return "redirect:/comments"; // Redirect to the list of comments after adding
    }

    // Edit an existing comment
    @GetMapping("/edit/{id}")
    public String editCommentForm(@PathVariable Long id, Model model) {
        commentsService.getCommentById(id).ifPresent(comment -> model.addAttribute("comment", comment));
        return "edit-comment"; // A form template for editing a comment
    }

    // Update comment after editing
    @PostMapping("/edit/{id}")
    public String updateComment(@PathVariable Long id, @RequestParam String content) {
        commentsService.editComment(id, content);
        return "redirect:/comments"; // Redirect to comments list after updating
    }

    // Delete comment action
    @PostMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentsService.deleteComment(id);
        return "redirect:/comments"; // Redirect to comments list after deletion
    }
}
